/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.libpasta;

public class Argon2i extends PrimitiveWrapper {
  private transient long swigCPtr;

  protected Argon2i(long cPtr, boolean cMemoryOwn) {
    super(pastaJNI.Argon2i_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Argon2i obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        pastaJNI.delete_Argon2i(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public Argon2i() {
    this(pastaJNI.new_Argon2i__SWIG_0(), true);
  }

  public Argon2i(int passes, int lanes, int kib) {
    this(pastaJNI.new_Argon2i__SWIG_1(passes, lanes, kib), true);
  }

}