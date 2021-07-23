vertclair='\e[1;32m'
rouge='\e[0;31m'
cd ..
files='file1 file2 file3 file4'
for file in files
do
	echo ${file}
	# si dernier code de reoutr != de 0
done
echo -en $vertclair"ALL TEST PASSED\n"
echo -en $rouge"SOME TEST FAILED !!!!\n"

#javac -classpath test4poo.jar test/*.java
