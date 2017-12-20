/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.libpasta;

import org.scijava.nativelib.*;

public class pastaJNI {
  public final static native long new_ResultHash__SWIG_0();
  public final static native long new_ResultHash__SWIG_1(boolean jarg1, String jarg2);
  public final static native long new_ResultHash__SWIG_2(long jarg1, ResultHash jarg1_);
  public final static native void ResultHash_first_set(long jarg1, ResultHash jarg1_, boolean jarg2);
  public final static native boolean ResultHash_first_get(long jarg1, ResultHash jarg1_);
  public final static native void ResultHash_second_set(long jarg1, ResultHash jarg1_, String jarg2);
  public final static native String ResultHash_second_get(long jarg1, ResultHash jarg1_);
  public final static native void delete_ResultHash(long jarg1);
  public final static native long verify_password_update_hash(String jarg1, String jarg2);

  static {
    try {
        NativeLoader.loadLibrary("pasta_jni");
    } catch (Exception e) {
      try {
        NativeLibraryUtil.loadNativeLibrary(pastaJNI.class, "pasta_jni");
      } catch (Exception e2) {
        System.err.println("Native code library failed to load. \n" + e);
        System.exit(1);
      }
    }
  }

  public final static native long PrimitiveWrapper_inner(long jarg1, PrimitiveWrapper jarg1_);
  public final static native void delete_PrimitiveWrapper(long jarg1);
  public final static native long new_Argon2i__SWIG_0();
  public final static native long new_Argon2i__SWIG_1(int jarg1, int jarg2, int jarg3);
  public final static native void delete_Argon2i(long jarg1);
  public final static native long new_Bcrypt__SWIG_0();
  public final static native long new_Bcrypt__SWIG_1(int jarg1);
  public final static native void delete_Bcrypt(long jarg1);
  public final static native long new_Scrypt__SWIG_0();
  public final static native long new_Scrypt__SWIG_1(short jarg1, long jarg2, long jarg3);
  public final static native void delete_Scrypt(long jarg1);
  public final static native long Config_with_primitive(long jarg1, PrimitiveWrapper jarg1_);
  public final static native String Config_hash_password(long jarg1, Config jarg1_, String jarg2);
  public final static native String Config_migrate_hash(long jarg1, Config jarg1_, String jarg2);
  public final static native boolean Config_verify_password(long jarg1, Config jarg1_, String jarg2, String jarg3);
  public final static native long Config_verify_password_update_hash(long jarg1, Config jarg1_, String jarg2, String jarg3);
  public final static native String hash_password(String jarg1);
  public final static native String migrate_hash(String jarg1);
  public final static native String read_password(String jarg1);
  public final static native boolean verify_password(String jarg1, String jarg2);
  public final static native long Argon2i_SWIGUpcast(long jarg1);
  public final static native long Bcrypt_SWIGUpcast(long jarg1);
  public final static native long Scrypt_SWIGUpcast(long jarg1);
}
