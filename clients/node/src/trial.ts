import { HelloGrpcClient } from './hello';

const main = async () => {
    const client = new HelloGrpcClient();

    const request = {
        name: 'asdasd',
    };

    const result = await client.callSayHello(request);
    if (!result) {
        throw new Error('no result');
    }

    console.log(result);
};

main()
    .then(() => {})
    .catch(console.error);
