##################################################
#					VARIABLES					 #
##################################################

sources = jeu/action/*.java \
		  jeu/board/*.java \
		  jeu/character/*.java \
		  jeu/exception/*.java \
		  jeu/player/*.java \
		  jeu/util/*.java \
		  jeu/util/io/*.java \
		  jeu/board/tile/*.java \
		  jeu/board/tile/resource/*.java \
		  jeu/game/*.java \
		  jeu/*.java \
		  jeu/strategy/*.java

srcTest = test/jeu/*.java \
		  test/jeu/action/*.java \
		  test/jeu/board/*.java \
		  test/jeu/board/tile/*.java \
		  test/jeu/board/tile/resource/*.java \
		  test/jeu/character/*.java

execTest = test/jeu/*.class \
		   test/jeu/action/*.class \
		   test/jeu/board/*.class \
		   test/jeu/board/tile/*.class \
		   test/jeu/board/tile/resource/*.class \
		   test/jeu/character/*.class	



#####################################################
#			Generer les executables					#
#####################################################
compile:
	@echo "compilation en cours ..."
	@cd src && javac ${sources} -d  ../classes && cd ..
	@echo "compilation terminée !"

#####################################################
#		Generer les executables de tests			#
#####################################################
testCompile:
	@echo "compilation en cours ..."
	@javac -classpath test4poo.jar ${srcTest}
	@echo "compilation teminée"

%:
	java -jar test4poo.jar $@

#####################################################
#			Generer la documentation				#
#####################################################
doc:
	@ echo "generation de la documentation ..."
	@ cd src && javadoc -d ../docs -subpackages jeu
	@ echo "document généré"

#####################################################
#	Nettoyer les fichiers facilement generables		#
#####################################################
clean:
	@ echo "suppression en cours ..."
	@rm -rf docs/*
	@rm -rf classes/*
	@rm -rf ${execTest}
	@ echo "suppression terminée"
