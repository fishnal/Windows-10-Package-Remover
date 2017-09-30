import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.InputStream;
import java.io.IOException;

public class ParsePackages {
	public static void main(String[] args) throws IOException {
		parse();	
	}

	public static Map<String, String> parse() throws IOException {
		Process p = Runtime.getRuntime().exec("powershell Get-AppxPackage");

		StringBuffer inStr = new StringBuffer();
		InputStream is = p.getInputStream();
		
		int data;
		while ((data = is.read()) != -1) {
			inStr.append((char) data);
		}

		Scanner strSc = new Scanner(inStr.toString());
		Map<String, String> packageMap = new HashMap<>();

		String name = null;
		String fullName = null;
		while (strSc.hasNextLine()) {
			String line = strSc.nextLine();

			if (line.startsWith("Name")) {
				name = line;
			} else if (line.startsWith("PackageFullName")) {
				fullName = line;
				packageMap.put(name, fullName);
				name = fullName = null;
			}
		}

		strSc.close();
		p.destroyForcibly();
		
		return packageMap;
	}
}