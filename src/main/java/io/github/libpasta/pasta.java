/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */
package io.github.libpasta;

public class pasta {
  public static String hash_password(String password) {
    return pastaJNI.hash_password(password);
  }

  public static boolean verify_password(String hash, String password) {
    return pastaJNI.verify_password(hash, password);
  }

  public static void free_string(String arg0) {
    pastaJNI.free_string(arg0);
  }

  public static String read_password(String prompt) {
    return pastaJNI.read_password(prompt);
  }

}
