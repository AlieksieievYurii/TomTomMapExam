# TomTomMapExam
For start you need to execute the JAR file by JVM.
	-- java -jar TTmap.jar

If you start my program TTmap you will see that program has two buttons: "Read JSON file" & "Read URL JSON".

If you press the button "Read JSON file",file chooser will open and you will need to choose only a JSON file.
Ofter that program parses JSON file and print points on Map(Image) and add them to array list.
But If you press "Cance" in file chooser, the program will not execute.

The other way, if you press the button "Read URL JSON", you will get file dialog and will need to enter URL link
to JSON file on sever.
I did tests on my local host. 
For instance:

	JSON file is in C:\usr\sever\www\testJSON\incidence.json

I write: http://localhost/~testJSON/incidence.json

Ofter that, Map will get points.
Also, if you press "Cance" in dialog file, the program will not execute.
But if you will wrong URL, in top right in Map, Image(dangerous) starts blinking.

In my program, you can click on points(They are clickable). For example, if you click on point, it will be green color and show 
in array list. Also print important information on display. It works conversely. If you chooise in array list, point will be green.

Also you can just put cursor on point and get information about it as hint.

The program does every two minutes query from server by URL.

The Jar file is in:TomTomMapExam/out/artifacts/MapTomTom_jar
