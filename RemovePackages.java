import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class RemovePackages {
	private static List<Process> processes = new ArrayList<>();
	private final static String COMMAND_TEMPLATE = "powershell \"Get-AppxPackage *package* | Remove-AppxPackage\"";

	public static void main(String[] args) throws Throwable {
		List<String> packages = new ArrayList<>();
		Scanner sc = new Scanner(new File(args[0]));

		while (sc.hasNextLine()) {
			packages.add(sc.nextLine());
		}

		for (String p : packages) {
			removePackage(p);
		}

		while (true) {
			for (Process p : processes) {
				if (p.isAlive()) {
					continue;
				}
			}

			break;
		}

		sc.close();
	}

	private static void removePackage(String shortID) throws Throwable {
		String cmd = COMMAND_TEMPLATE.replace("*package*", String.format("*%s*", shortID));
		Process p = Runtime.getRuntime().exec(cmd);
		processes.add(p);
	}
}