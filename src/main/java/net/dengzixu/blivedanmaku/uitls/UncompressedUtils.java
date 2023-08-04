package net.dengzixu.blivedanmaku.uitls;

import org.apache.commons.compress.compressors.brotli.BrotliCompressorInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

public class UncompressedUtils {
    // Logger
    private static final Logger logger = LoggerFactory.getLogger(UncompressedUtils.class);

    public static byte[] uncompressed(byte[] data, Compressor compressor) {
        if (null == data || data.length == 0) {
            return null;
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        InputStream inputStream = null;

        try {
            switch (compressor) {
                case ZLIB -> inputStream = new InflaterInputStream(byteArrayInputStream);
                case BROTLI -> inputStream = new BrotliCompressorInputStream(byteArrayInputStream);
            }
            byte[] buffer = new byte[1024];

            int n;
            while ((n = inputStream.read(buffer)) >= 0) {
                byteArrayOutputStream.write(buffer, 0, n);
            }
        } catch (IOException e) {
            logger.error("uncompressed error", e);
        }

        return byteArrayOutputStream.toByteArray();
    }

    public enum Compressor {
        ZLIB,
        BROTLI;
    }
}
