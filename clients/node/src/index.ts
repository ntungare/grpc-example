import { HelloRequest } from '../generated/hello_pb';
import { HelloGrpcClient } from './hello';

const main = async () => {
    const client = new HelloGrpcClient();

    const request = new HelloRequest();
    request.setName('asdsad');

    const result = await client.callSayHello(request);
    if (!result) {
        throw new Error('no result');
    }

    console.log(result);
};

main()
    .then(() => {})
    .catch(console.error);
