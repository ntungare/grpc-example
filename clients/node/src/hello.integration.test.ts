import { HelloGrpcClient } from './hello';

import type { HelloRequest } from './generated/hello';

describe('HelloGrpcClient', () => {
    it('should call sayHello and resolve with the response', async () => {
        const client = new HelloGrpcClient();
        const request: HelloRequest = {
            name: 'John Doe',
        };
        const result = await client.callSayHello(request);
        expect(result.message).toContain(request.name);
    });
});
