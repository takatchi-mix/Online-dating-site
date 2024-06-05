package hoge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Hello {

    public static HashMap<String, ArrayList<String>> ranking;
    public static HashMap<String, String> matching;
    private static Random rand;

    public static void main(String[] args){
        matching = new HashMap<String, String>();
        // 変数初期化
        matching.put("ソラ", "");
        matching.put("ドナルド","");
        matching.put("ミッキー", "");
        matching.put("グーフィー", "");
        matching.put("リク", "");
        matching.put("ロクサス","");
        matching.put("アクセス", "");
        ranking = new HashMap<String, ArrayList<String>>();
        ranking.put("ソラ", new ArrayList<>());
        ranking.put("ドナルド",new ArrayList<>());
        ranking.put("ミッキー", new ArrayList<>());
        ranking.put("グーフィー", new ArrayList<>());
        ranking.put("リク", new ArrayList<>());
        ranking.put("ロクサス", new ArrayList<>());
        ranking.put("アクセス", new ArrayList<>());
        ranking.put("ラクシーヌ", new ArrayList<>());
        ranking.put("ミニー", new ArrayList<>());
        ranking.put("デイジー", new ArrayList<>());
        ranking.put("アクア", new ArrayList<>());
        ranking.put("シオン", new ArrayList<>());
        ranking.put("ナミネ", new ArrayList<>());
        ranking.put("カイリ", new ArrayList<>());



        Collections.addAll(ranking.get("ソラ"), "カイリ", "ミニー", "デイジー", "シオン", "ナミネ", "アクア", "ラクシーヌ");
        Collections.addAll(ranking.get("ドナルド"), "ミニー", "カイリ", "デイジー", "シオン", "ナミネ", "アクア", "ラクシーヌ");
        Collections.addAll(ranking.get("ミッキー"), "ラクシーヌ", "ミニー", "デイジー", "シオン", "ナミネ", "アクア", "カイリ");
        Collections.addAll(ranking.get("グーフィー"), "アクア", "シオン", "カイリ", "ナミネ", "ラクシーヌ", "ミニー", "デイジー");
        Collections.addAll(ranking.get("リク"), "カイリ", "ナミネ", "ラクシーヌ", "ミニー", "デイジー", "アクア", "シオン");
        Collections.addAll(ranking.get("ロクサス"), "ラクシーヌ", "ミニー", "デイジー", "シオン", "ナミネ", "アクア", "カイリ");
        Collections.addAll(ranking.get("アクセス"), "シオン", "ナミネ", "デイジー", "シオン", "ラクシーヌ", "ミニー", "デイジー");

        Collections.addAll(ranking.get("ラクシーヌ"), "ミッキー", "ドナルド", "ロクサス", "グーフィー", "ソラ", "リク", "アクセス");
        Collections.addAll(ranking.get("ミニー"), "グーフィー", "ロクサス", "リク", "アクセス", "ドナルド", "ソラ", "ミッキー");
        Collections.addAll(ranking.get("デイジー"), "ソラ", "ミッキー", "アクセス", "ロクサス", "グーフィー", "ドナルド", "リク");
        Collections.addAll(ranking.get("アクア"), "ロクサス", "リク", "ミッキー", "ドナルド", "ソラ", "アクセス", "グーフィー");
        Collections.addAll(ranking.get("シオン"), "アクセス", "ミッキー", "グーフィー", "ドナルド", "ソラ", "リク", "ロクサス");
        Collections.addAll(ranking.get("ナミネ"), "リク", "ロクサス", "ミッキー", "ソラ", "ドナルド", "グーフィー", "アクセス");
        Collections.addAll(ranking.get("カイリ"), "グーフィー", "ロクサス", "ソラ", "アクセス", "ドナルド", "ミッキー", "リク");



        while(true)
        {
            // 現在の状況を表示
            dump();

            // 独身男性を探す
            String singleManName = "";
            for (String manName : matching.keySet()) {
                if(matching.get(manName) == "")
                {
                    singleManName = manName;
                    break;
                }
            }

            // 独身男性がもういない場合
            if(singleManName == "")
            {
                System.out.println("フリーの人がいなくなったため、プログラムを終了します。");
                return;
            }

            // 独身男性の好みの女性を調べてプロポーズする
            String bestWomanName = ranking.get(singleManName).get(0);
            System.out.println(singleManName + "が、一番好きな" + bestWomanName + "にアタックしました。");

            // この女性が独身か調べる
            String husbandName = "";
            for (String manName : matching.keySet()) {
                if(matching.get(manName) == bestWomanName)
                {
                    husbandName = manName;
                    System.out.println("ところが" + bestWomanName + "は" + husbandName + "と付き合っています。");
                    break;
                }
            }

            // この女性が独身だった場合は婚約
            if(husbandName == "")
            {
                System.out.println(bestWomanName + "は現在フリーのため" + singleManName + "と付き合うことにしました。");
                matching.put(singleManName, bestWomanName);
                continue;
            }
            else
            {
                // 婚約中の hasbandName と、プロポーズしてきた singleManName 、どちらが好みか調べる
                for(String str : ranking.get(bestWomanName))
                {
                    // husbandName のほうが好みの場合
                    if(str == husbandName)
                    {
                        // singleManはこの女性に今後二度とプロポーズしない
                        System.out.println(bestWomanName + "は" + singleManName + "より" + husbandName + "が好きです。" + singleManName + "は" + bestWomanName + "を諦めました。");
                        ranking.get(singleManName).remove(bestWomanName);
                        break;
                    }

                    // husbandName のほうが好みの場合
                    if(str == singleManName)
                    {
                        // 婚約
                        System.out.println(bestWomanName + "は" + husbandName + "より" + singleManName + "が好きなので、乗り換えることにしました。");
                        matching.put(singleManName, bestWomanName);
                        matching.put(husbandName, "");
                        break;
                    }
                }
            }
        }

    }

    // 現在の状態を表示する関数
    public static void dump()
    {
        System.out.println("");

        System.out.println("■現在のランキング");
        for (String key : ranking.keySet()) {
            System.out.println("・" + key + " " + ranking.get(key));
        }

        System.out.println("◆現在のマッチング");
        for (String manName : matching.keySet()) {
            System.out.println("・" + manName + " ⇔ " + matching.get(manName));
        }

        System.out.println("");
    }
}
