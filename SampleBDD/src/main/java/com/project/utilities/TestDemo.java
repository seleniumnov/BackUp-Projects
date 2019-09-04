package com.project.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {

	
	public static int getCountOfTags() {

		List<String> tag = new ArrayList<String>();

		File file = new File(
				"C:\\Users\\suresh.kurry\\eclipse-workspace\\SampleBDD\\src\\test\\resources\\FeatureFiles");

		FileInputStream fin = null;
		BufferedReader b = null;

		for (File f : file.listFiles()) {

			if (f.isDirectory()) {

				for (File files : f.listFiles()) {

					System.out.println(files.getName());

					try {
						fin = new FileInputStream(files);

						b = new BufferedReader(new InputStreamReader(fin));

						String line = b.readLine();

						while (line != null) {

							if (line.contains("@Smoke")) {

								tag.add(line);
							}
							line = b.readLine();
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							b.close();
							fin.close();
						} catch (Exception e2) {

						}
					}
				}
			} else {

				System.out.println(f.getName());

				try {
					fin = new FileInputStream(f);

					b = new BufferedReader(new InputStreamReader(fin));

					String line = b.readLine();

					while (line != null) {

						if (line.contains("@Smoke")) {

							tag.add(line);
						}
						line = b.readLine();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						b.close();
						fin.close();
					} catch (Exception e2) {

					}
				}

			}
		}
		System.out.println(tag.size());
		return tag.size();
		

	}

}
