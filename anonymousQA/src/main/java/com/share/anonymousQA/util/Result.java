package com.share.anonymousQA.util;

import com.share.anonymousQA.enums.RES_STATUS;
import lombok.Data;

@Data
public class Result<T> {

	/**
	 * 对外返回的对象
	 */
	private T data;

	/**
	 * 返回状态码
	 */
	private int code;

	/**
	 * 返回消息
	 */
	private String msg;

	public Result() {
		super();
	}

	public Result(RES_STATUS status) {
		super();
		this.code = status.code;
		this.msg = status.msg;
	}

	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Result(T data, RES_STATUS status) {
		super();
		this.data = data;
		this.code = status.code;
		this.msg = status.msg;
	}

	public Result(T data, int code, String msg) {
		super();
		this.data = data;
		this.code = code;
		this.msg = msg;
	}

	public void setStatus(RES_STATUS status) {
		this.code = status.code;
		this.msg = status.msg;
	}
	/**
	 * 服务器unix utc时间戳秒值
	 */
	public long getTimestamp() {
		return System.currentTimeMillis() / 1000;
	}

	public static Result success() {
		return new Result(RES_STATUS.SUCCESS);
	}

}
