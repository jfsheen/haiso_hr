package com.haiso.commons.utils.param;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.*;

/**
 * Created by Heli on 2014/5/22.
 */
public final class PackUtil {
    public static String Pack(String in){
        return new Base64().encodeAsString(gzip(in));
    }
    public static String Unpack(String in){
        return new String(gunzip(new Base64().decode(in.getBytes())));
    }

    private static byte[] gzip(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzip != null) {
                try {
                    gzip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return out.toByteArray();
    }

    /**
     * 使用gzip进行解压缩
     * @param bytes
     * @return 解压后的byte[]
     */
    private static byte[] gunzip(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;
        GZIPInputStream gzipis = null;
        byte[] decompressed = null;
        try {
            in = new ByteArrayInputStream(bytes);
            gzipis = new GZIPInputStream(in);
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = gzipis.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (gzipis != null) {
                try {
                    gzipis.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }
    /**
     * 使用zip进行压缩
     * @param str  压缩前的文本
     * @return 返回压缩后的bytes
     */
    private static byte[] zip(String str) {
        if (str == null || str.length() == 0)
            return null;
        byte[] compressed = null;
        ByteArrayOutputStream out = null;
        ZipOutputStream zout = null;
        String compressedStr = null;
        try {
            out = new ByteArrayOutputStream();
            zout = new ZipOutputStream(out);
            zout.putNextEntry(new ZipEntry("0"));
            zout.write(str.getBytes());
            zout.closeEntry();
            compressed = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zout != null) {
                try {
                    zout.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return compressed;
    }

    /**
     * 使用zip进行解压缩
     * @param compressed  压缩后的文本
     * @return 解压后的byte
     */

    private static byte[] unzip(byte[] compressed) {
        if (compressed == null || compressed.length ==0) {
            return null;
        }
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        ZipInputStream zin = null;
        byte[] decompressed = null;
        try {
            out = new ByteArrayOutputStream();
            in = new ByteArrayInputStream(compressed);
            zin = new ZipInputStream(in);
            zin.getNextEntry();
            byte[] buffer = new byte[1024];
            int offset = -1;
            while ((offset = zin.read(buffer)) != -1) {
                out.write(buffer, 0, offset);
            }
            decompressed = out.toByteArray();
        } catch (IOException e) {
            decompressed = null;
        } finally {
            if (zin != null) {
                try {
                    zin.close();
                } catch (IOException e) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
        return decompressed;
    }
}
