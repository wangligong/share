package com.share.anonymousQA.enums;

public enum RES_STATUS {

	SUCCESS(200,"操作成功");

	RES_STATUS(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public final int code;
	public final String msg;

	public static RES_STATUS findStatusByCode(int code) {
		for (RES_STATUS status : RES_STATUS.values()) {
			if (status.code == code) {
				return status;
			}
		}
		return null;
	}
}
