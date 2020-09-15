package com.assignment.operations;

        import com.assignment.email.MailConfiguration;
        import com.assignment.email.MailSending;
        import com.assignment.fileOperations.FileWrite;
        import com.assignment.timeStamp.SavedTimeStamp;

        import java.util.List;
        import java.util.Scanner;

public class FileNotExistOperation implements Operation{
    @Override
    public void performOperation(FileWrite fileWrite, Scanner scanner, SavedTimeStamp savedTimeStamp,
                                 MailConfiguration mailConfiguration, MailSending mailSending, List<String> emailList,
                                 List<String> timeStampList) {
        String logLine;
        int index;
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        while (scanner.hasNextLine()){
            logLine = scanner.nextLine();
            if(logLine.contains("ERROR")){
                index = timeStampList.indexOf(logLine.split(" ")[0]);
                for(int i=index+1; i<timeStampList.size(); i++){
                    if(timeStampList.get(i).equals(timeStampList.get(index))){
                        continue;
                    }
                    else{
                        index = i;
                        break;
                    }
                }
                fileWrite.writeFile(timeStampList.get(index),outputPath);
                //mailSending.sendMail(mailConfiguration,emailList);
                break;
            }
        }

    }
}

