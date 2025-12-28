import { HelloGrpcClient } from './hello';
import { HelloServiceClient } from './generated/hello';
import type { HelloRequest, HelloResponse } from './generated/hello';

jest.mock('./generated/hello');

const MockedHelloServiceClient = HelloServiceClient as jest.MockedClass<typeof HelloServiceClient>;
const mockedSayHello = jest.fn();
MockedHelloServiceClient.prototype.sayHello = mockedSayHello;

describe('HelloGrpcClient', () => {
    it('should call sayHello and resolve with the response', async () => {
        const client = new HelloGrpcClient();
        const request: HelloRequest = {
            name: 'John Doe',
        };
        const response: HelloResponse = {
            message: 'Hello John Doe',
        };
        mockedSayHello.mockImplementation((receivedRequest, callback) => {
            expect(receivedRequest).toEqual(request);
            callback(null, response);
        });
        const result = await client.callSayHello(request);
        expect(result).toEqual(response);
    });

    it('should call sayHello and reject with the response', async () => {
        const client = new HelloGrpcClient();
        const request: HelloRequest = {
            name: 'John Doe',
        };
        mockedSayHello.mockImplementation((receivedRequest, callback) => {
            expect(receivedRequest).toEqual(request);
            callback(new Error('Something went wrong'), null);
        });
        await expect(client.callSayHello(request)).rejects.toThrow('Something went wrong');
    });
});
