import { fixImportsPlugin } from 'esbuild-fix-imports-plugin';
import { defineConfig, type Options } from 'tsup';

const commonOptions: Partial<Options> = {
    entry: ['src/**/*', '!src/**/*.test.ts', '!src/**/*.int.test.ts'],
    experimentalDts: true,
    clean: true,
    bundle: false,
    sourcemap: true,
    splitting: false,
    tsconfig: './tsconfig.json',
    esbuildPlugins: [fixImportsPlugin()],
};

export default defineConfig([
    {
        ...commonOptions,
        format: 'cjs',
        outDir: 'dist/cjs',
    },
    {
        ...commonOptions,
        format: 'esm',
        outDir: 'dist/esm',
    },
]);
