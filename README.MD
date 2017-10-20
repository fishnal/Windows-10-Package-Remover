# Windows 10 Package Remover

A small Java-based program that removes `.appx` packages on Windows 10 computers. A text file is provided for some common applications to remove that most may not use, such as the Messaging and Phone apps.

### Usage
```
java RemovePackages packages.txt
```
The above command reads in any short-hand identifiers for a Windows 10 appx package from the file `packages.txt` and removes those packages. These short-hand identifiers are NOT the full names of the packages. These short IDs were pulled from [this Reddit comment]("https://www.reddit.com/r/pcmasterrace/comments/736tfh/skype_is_officially_bloatware_uninstalled_it/dno4ga5/").
