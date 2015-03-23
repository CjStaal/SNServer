/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.message.executor;

/**
 * This is the interface DefaultMessageQueue uses. It is empty so that nobody
 * can accidently use a method inside it. I know I can just use private methods,
 * and I do, but I feel this adds another level of security.
 *
 * @author Charles Joseph Staal
 */
public interface MessageExecutor extends Runnable {
}
