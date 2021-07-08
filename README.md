# indic-transliterator

Transliterate text across indian language pairs.
Reads from STDIN and writes to STDOUT.

## Compile

```
javac Transliterate.java
```

## Run
Usage:

```
echo "<Text in source language>" | java Transliterate KAN HIN
```

Example:

```
echo "ಮುಖ್ಯ ಪುಟ" | java Transliterate KAN HIN
```
## TODO
Add support for all Indian languages. For this, just add the first unicode value of each languiage with 3 letter code to hashmap.

## Disclaimer
The code is not robust (like handling of command line arguments) and many corner cases may not have been handled.
