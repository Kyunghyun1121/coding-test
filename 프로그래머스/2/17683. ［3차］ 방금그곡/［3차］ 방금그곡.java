import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = findMusic(m, musicinfos);
        return answer;
    }

    private String findMusic(String m, String[] musicinfos) {
        int maxMusicLen = 0;
        String maxTitle = "(None)";

        for (String musicinfo : musicinfos) {
            String[] musicinfoArr = musicinfo.split(",");
            String start = musicinfoArr[0];
            String end = musicinfoArr[1];
            String title = musicinfoArr[2];
            String score = musicinfoArr[3];

            int musicLen = getMusicLen(start, end);
            score = recreateScore(score, musicLen);

            boolean found = score.contains(m);
            boolean isNextShap = isNextShap(m, score);

            if (found && !isNextShap && musicLen > maxMusicLen) {
                maxTitle = title;
                maxMusicLen = musicLen;
            }
        }

        return maxTitle;
    }


    private int getMusicLen(String start, String end) {
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");
        int startHour = Integer.parseInt(startSplit[0]);
        int startMin = Integer.parseInt(startSplit[1]);
        int endHour = Integer.parseInt(endSplit[0]);
        int endMin = Integer.parseInt(endSplit[1]);

        return (endHour * 60 + endMin) - (startHour * 60 + startMin);
    }

    private String recreateScore(String score, int musicLenCount) {
        int count = 0;
        StringBuilder reScore = new StringBuilder();
        for (int i=0; count<musicLenCount; i++) {
            char ch = score.charAt(i % score.length());
            char next = score.charAt((i + 1) % score.length());

            count++;
            reScore.append(ch);

            if (next == '#') {
                i++;
                reScore.append('#');
            }
        }

        return reScore.toString();
    }
    private boolean isNextShap(String m, String score) {
        int index = 0;
        boolean isNextShap = true;
        while ((index = score.indexOf(m, index)) >= 0) {
            index = (index + m.length()) % score.length();
            if (score.charAt(index) != '#') {
                isNextShap = false;
                break;
            }
        }

        return isNextShap;
    }
}