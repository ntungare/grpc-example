import { status, Metadata } from '@grpc/grpc-js';

import { HelloServiceClient } from './generated/hello';
import { HelloGrpcClient } from './hello';

import type { ServiceError } from '@grpc/grpc-js';

import type { HelloRequest, HelloResponse } from './generated/hello';

jest.mock('./generated/hello');

const MockedHelloServiceClient = HelloServiceClient as jest.MockedClass<typeof HelloServiceClient>;

class CustomError extends Error implements ServiceError {
    code: status;
    details: string;
    metadata: Metadata;

    constructor(message: string) {
        super(message);
        this.code = status.UNAVAILABLE;
        this.details = message;
        this.metadata = new Metadata();
    }
}

describe('HelloGrpcClient', () => {
    it('should call sayHello and resolve with the response', async () => {
        const client = new HelloGrpcClient();
        const request: HelloRequest = {
            name: 'John Doe',
        };
        const response: HelloResponse = {
            message: 'Hello John Doe',
        };
        MockedHelloServiceClient.prototype.sayHello.mockImplementation(
            (
                receivedRequest: HelloResponse,
                callback: (error: ServiceError | null, response: HelloResponse) => void
            ) => {
                expect(receivedRequest).toEqual(request);
                callback(null, response);
            }
        );
        const result = await client.callSayHello(request);
        expect(result).toEqual(response);
    });

    it('should call sayHello and reject with the response', async () => {
        const client = new HelloGrpcClient();
        const request: HelloRequest = {
            name: 'John Doe',
        };
        MockedHelloServiceClient.prototype.sayHello.mockImplementation(
            (
                receivedRequest: HelloResponse,
                callback: (error: ServiceError | null, response: HelloResponse) => void
            ) => {
                expect(receivedRequest).toEqual(request);
                callback(new CustomError('Something went wrong'), null);
            }
        );
        await expect(client.callSayHello(request)).rejects.toThrow('Something went wrong');
    });
});
