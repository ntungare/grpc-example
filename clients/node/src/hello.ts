import * as grpc from '@grpc/grpc-js';

import { HelloServiceClient } from '../generated/hello_grpc_pb';
import { HelloRequest, HelloResponse } from '../generated/hello_pb';

export class HelloGrpcClient {
    private readonly client: HelloServiceClient;

    constructor(address: string = 'localhost:9090') {
        this.client = new HelloServiceClient(address, grpc.credentials.createInsecure());
    }

    public async callSayHello(request: HelloRequest): Promise<HelloResponse.AsObject> {
        return new Promise((resolve, reject) => {
            new HelloRequest()
            this.client.sayHello(request, (err, value) => {
                if (err) {
                    reject(err);
                }

                resolve(value?.toObject());
            });
        });
    }
}
