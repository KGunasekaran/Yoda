collection is a folder that will contain a test suite file or a super suite file

test suite file -> BAT.ts : will contains a list of test file name(s)
super suite file -> Regression.sts : will contain the list of names of the test suite file

when we pass the test suite file, Nobel will find the list of test files from the folder structure and executes them
when we pass the super test suite file, Nobel will find the test suite files and from there it will collect the test file that need to be executed.
