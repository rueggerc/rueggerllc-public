package com.rueggerllc.bootstrap.filters;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class ByteArrayServletOutputStream extends ServletOutputStream {
	
	private ByteArrayOutputStream stream = new ByteArrayOutputStream();


	@Override
	public void write(int b) throws IOException {
		stream.write(b);
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		stream.write(b);
	}
	
	@Override
	public void write(byte[] b, int offset, int length) throws IOException {
		stream.write(b,  offset, length);
	}
	
	@Override
	public String toString() {
		return stream.toString();
	}

	@Override
	public boolean isReady() {
		return true;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
	}
	
	
	

}
