package com.service.forecast;

import org.apache.servicecomb.foundation.ssl.SSLCustom;

public class MyCert extends SSLCustom {

	@Override
	public char[] decode(char[] arg0) {

		return arg0;
	}

	@Override
	public String getFullPath(String arg0) {
		return "d:\\cert\\" +arg0;
	}

}
