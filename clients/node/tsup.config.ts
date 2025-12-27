import { fixImportsPlugin } from 'esbuild-fix-imports-plugin';
import { defineConfig } from 'tsup';

export default defineConfig([
    {
        entry: ['src/**/*'],
        format: 'cjs',
        outDir: 'dist/cjs',
        experimentalDts: true,
        clean: true,
        bundle: false,
        sourcemap: true,
        splitting: false,
        tsconfig: './tsconfig.json',
        esbuildPlugins: [fixImportsPlugin()],
    },
    {
        entry: ['src/**/*'],
        format: 'esm',
        outDir: 'dist/esm',
        experimentalDts: true,
        clean: true,
        bundle: false,
        sourcemap: true,
        splitting: false,
        tsconfig: './tsconfig.json',
        esbuildPlugins: [fixImportsPlugin()],
    },
]);
