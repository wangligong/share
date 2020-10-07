package com.share.anonymousQA.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static String ROOT_PATH = String.format("%s/%s/", "C:/Users/LCZQ-BJ-User/Desktop/", "question");

	/**
	 * 将内容以追加的形式写入txt
	 * @param content
	 * @throws IOException
	 */
	public static void writeToTxt(String content) throws IOException {
		String dirPath = genrateDirPath();

		String filePath = String.format("%s%s.txt", dirPath, "QUESTION");

		//将写入转化为流的形式
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		bw.write(content);
		bw.newLine();
		//关闭流
		bw.close();
	}

	private static String genrateDirPath() {
		File file = new File(ROOT_PATH);
		if(!file.exists()) {
			file.mkdir();
		}
		return ROOT_PATH;
	}

	/**
	 * 读取文件
	 * @return
	 */
	public static List<String> readFile() {
		List<String> list = new ArrayList<>();
		String filePath = String.format("%s%s.txt", ROOT_PATH, "QUESTION");
		try (FileReader reader = new FileReader(filePath);
			 BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
		) {
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
