package com.example.bduservices

data class Category(
    val id: Int, // Unique identifier
    val name: String,
    val services: List<Service>,
    val imageResId: Int
)

data class Service(
    val id: Int,
    val name: String,
    val price: Int
)

object ServiceData {
    val categories = listOf(
        Category(
            id = 1,
            "የጾም ምግቦች",
            services = listOf(
                Service(id = 101, "በየአይነቱ", 60),
                Service(id = 102, "ሽሮ ፈሰስ", 40),
                Service(id = 103, "እንጀራ ፍርፍር", 50),
                Service(id = 104, "ተጋቢኖ", 50),
                Service(id = 105, "አትክልት በእንጀራ", 50),
                Service(id = 106, "ቲማቲም ስልስ በ2 ዳቦ", 50),
                Service(id = 107, "ፓስታ በአትክልት በ2 ዳቦ", 50),
                Service(id = 108, "ሩዝ በ2 ዳቦ", 50),
                Service(id = 109, "ቲማቲም ቁርጥ", 45),
                Service(id = 110, "ሽሮ በቲማቲም ቁርጥ", 50),
                Service(id = 111, "አትክልት በ2 ዳቦ", 50),
                Service(id = 112, "ሩዝ በአትክልት ከ2 ዳቦ ጋር", 50),
                Service(id = 113, "ሩዝ በአትክልት ብቻ", 40),
                Service(id = 114, "ምስር ወጥ", 50),
                Service(id = 115, "ፓስታ በ2 ዳቦ", 50),
                Service(id = 116, "ፓስታ በእንጀራ", 50),
                Service(id = 117, "አልጫ ሽሮ", 40),
                Service(id = 118, "ድንች ወጥ", 45),
                Service(id = 119, "ሽሮ ፍትፍት", 40),
                Service(id = 120, "ዳቦ ፍርፍር በ2 ዳቦ", 40),
                Service(id = 121, "መኮረኒ በ2 ዳቦ(በእንጀራ)", 50),
                Service(id = 122, "ሙሉ ፍርፍር", 55),
                Service(id = 123, "እስፔሻል ጾም ፍርፍር", 60),
                Service(id = 124, "እስፔሻል ሽሮ", 50),
                Service(id = 125, "ቲማቲም ለብለብ", 50),
                Service(id = 126, "ሙሉ ድንች ፍርፍር", 60),
                Service(id = 127, "ሽሮ ላላ", 50),
                Service(id = 128, "ድንች ፍርፍር", 50),
                Service(id = 129, "ምስር በድንች", 60)
            ),
            R.drawable.food
        ),

        Category(
            id = 2,
            "የፍስክ ምግቦች",
            services = listOf(
                Service(id = 201, "የበሬ ጥብስ", 120),
                Service(id = 202,"የበግ ጥብስ", 130),
                Service(id = 203,"እንቁላል በስጋ", 110),
                Service(id = 204,"እንቁላል ስልስ በ2 ዳቦ(እንጀራ)", 60),
                Service(id = 205,"እንቁላል ፍርፍር በ2 ዳቦ(እንጀራ)", 60),
                Service(id = 206,"እንቁላል ሳንድዊች በ150 ግራም ዳቦ", 50),
                Service(id = 207,"ድንች በስጋ", 75),
                Service(id = 208,"ምስር በስጋ", 75),
                Service(id = 209,"ሙሉ ስጋ ፍርፍር", 110),
                Service(id = 210,"ስጋ ፍርፍር", 90),
                Service(id = 211,"ፓስታ በእንቁላል በ2 ዳቦ", 85),
                Service(id = 212,"ፓስታ በስጋ", 90),
                Service(id = 213,"እስፔሻል ስጋ ፍርፍር", 100),
                Service(id = 214,"ቋንጣ ፍርፍር", 100),
                Service(id = 215,"እስፔሻል ቋንጣ ፍርፍር", 100),
                Service(id = 216,"ምንቸት", 100),
                Service(id = 217,"ቀይ ወጥ", 100),
                Service(id = 218,"ሚስቶ", 90),
                Service(id = 219,"ሩዝ በስጋ", 80),
                Service(id = 220,"መኮረኒ በስጋ", 80)
            ),
            R.drawable.kurt
        ),
        Category(
            id = 3,
            "ትኩስ መጠጦች",
            services = listOf(
                Service(id = 301, "ሻይ", 10),
                Service(id = 302, "ብርቱካን ሻይ", 15),
                Service(id = 303, "አናናስ ሻይ", 15),
                Service(id = 304, "ማንጎ ሻይ", 15),
                Service(id = 305, "ቡና", 10),
                Service(id = 306, "ለውዝ", 15),
                Service(id = 307, "ወተት", 20),
                Service(id = 308, "ማኪያቶ", 15),
                Service(id = 309, "እስፕሪስ", 10),
                Service(id = 310, "ቅሽር", 10)
            ),
            R.drawable.tea
        ),

        Category(
            id = 4,
            "የቀዝቃዛ መጠጦች",
            services = listOf(
                Service(id = 401, "የለስላሳ መጠጦች ኮካ", 30),
                Service(id = 402, "ውሃ ½ ሊትር", 15),
                Service(id = 403, "ውሃ 1 ሊትር", 25),
                Service(id = 404, "ውሃ 2 ሊትር", 30),
                Service(id = 405, "ስንቅ", 45),
                Service(id = 406, "ማልታ", 45)
            ),
            R.drawable.drinks
        ),

        Category(
            id = 5,
            "የጀበና ቡና እና ሻይ",
            services = listOf(
                Service(id = 501, "የጀበና ቡና", 10),
                Service(id = 502, "ሻይ", 10)
            ),
            R.drawable.jebena
        ),

        Category(
            id = 6,
            "ዳቦና ተመሳሳይ አይነቶች",
            services = listOf(
                Service(id = 601, "ዳቦ 150 ግራም", 10),
                Service(id = 602, "ሳንቡሳ", 15),
                Service(id = 603, "ቦንቦሊኖ", 15),
                Service(id = 604, "አንባሻ", 15),
                Service(id = 605, "ቆቆር", 15)
            ),
            R.drawable.bread
        ),

       Category(
            id = 7,
            "ፋስት ፉድ ፣ ትኩስና ፈጣን ምግቦች",
            services = listOf(
                Service(id = 701, "ሻይ", 10),
                Service(id = 702, "ብርቱካን ሻይ", 15),
                Service(id = 703, "አናናስ ሻይ", 15),
                Service(id = 704, "ማንጎ ሻይ", 15),
                Service(id = 705, "ወተት", 20),
                Service(id = 706, "ቦንቦሊኖ", 15),
                Service(id = 707, "ዶናት", 15),
                Service(id = 708, "ሳንቡሳ", 15),
                Service(id = 709, "አንባሻ", 15),
                Service(id = 710, "ፒዛ በአትክልት", 80),
                Service(id = 711, "እርጥብ", 40),
                Service(id = 712, "ፈንድሻ", 20),
                Service(id = 713, "የተቀቀለ እንቁላል", 15),
                Service(id = 714, "ኖርማል ፉል በ2 ዳቦ", 45),
                Service(id = 715, "እስፔሻል ፉል በ2 ዳቦ", 50),
                Service(id = 716, "እንቁላል ሳንድዊች በ150 ግራም ዳቦ", 50),
                Service(id = 717, "እንቁላል ፍርፍር በ2 ዳቦ ብቻ", 60),
                Service(id = 718, "እንቁላል ስልስ በ2 ዳቦ ብቻ", 60),
                Service(id = 719, "ዳቦ ፍርፍር በ2 ዳቦ ብቻ", 40),
                Service(id = 720, "ፓስታ በ2 ዳቦ ብቻ", 50),
                Service(id = 721, "ፓስታ በእንቁላል በ2 ዳቦ ብቻ", 85),
                Service(id = 722, "መኮረኒ በ2 ዳቦ ብቻ", 50),
                Service(id = 723, "መኮረኒ በእንቁላል በ2 ዳቦ ብቻ", 85),
                Service(id = 724, "አትክልት በ2 ዳቦ ብቻ", 50),
                Service(id = 725, "ፓስታ በአትክልት በ2 ዳቦ ብቻ", 55),
                Service(id = 726, "ሩዝ በ2 ዳቦ ብቻ", 50),
                Service(id = 727, "ሩዝ በአትክልት በ2 ዳቦ ብቻ", 50),
                Service(id = 728, "ቲማቲም ስልስ በ2 ዳቦ ብቻ", 50),
                Service(id = 729, "የተለያዩ ፍራፍሬ ጭማቂ (ጁስ)", 60),
                Service(id = 730, "የታሸገ ወተት ግማሽ ሊትር", 30),
                Service(id = 731, "የታሸገ እርጎ ትልቁ", 45),
                Service(id = 732, "የታሸገ እርጎ ትንሹ", 30),
                Service(id = 733, "እስፔሻል እርጥብ", 50),
                Service(id = 734, "የለስላሳ መጠጦች ኮካ(ሞሃ)", 30),
                Service(id = 735, "ዉሃ ½ ሊትር", 15),
                Service(id = 736, "ዉሃ 1 ሊትር", 25),
                Service(id = 737, "ዉሃ 2 ሊትር", 30),
                Service(id = 738, "ስንቅ", 45),
                Service(id = 739, "ማልት", 45)
            ),
            R.drawable.fastfood
            ),

       Category(
            id = 8,
            "ፍራፍሬዎች",
            services = listOf(
               Service(id = 801, name = "ሙዝ 1 ኪ.ግ", price = 70),
                Service(id = 802, name = "ብርቱካን 1 ኪ.ግ", price = 150),
                Service(id = 803, name = "አቮካዶ 1 ኪ.ግ", price = 50),
                Service(id = 804, name = "ፓፓያ 1 ኪ.ግ", price = 75),
                Service(id = 805, name = "ሀብሀብ 1 ኪ.ግ", price = 40),
                Service(id = 806, name = "አፕል 1 ኪ.ግ", price = 90)
            ),
            R.drawable.fruit
        ),

       Category(
            id = 9,
            "የሱቅ ዕቃዎች",
            services = listOf(
                Service(id = 901, "ዲቫ ሳሙና ያልታሸገ", 43),
                Service(id = 902, "ዲቫ ሳሙና የታሸገ", 60),
                Service(id = 903, "ሶላር ሳሙና", 60),
                Service(id = 904, "ላይፍ ቦይ 70 ግራም", 40),
                Service(id = 905, "ላክስ ሳሙና", 45),
                Service(id = 906, "ዱሩ ሳሙና ትንሹ", 115),
                Service(id = 907, "ዱሩ ትልቁ", 140),
                Service(id = 908, "አጃክስ ትልቁ", 15),
                Service(id = 909, "ሜዲካም ሳሙና", 95),
                Service(id = 910, "ተንጠልጣይ ቫይቴክስ", 10),
                Service(id = 911, "ብራይት ስፔሻል 1 ሊትር", 125),
                Service(id = 912, "ላርጎ 1 ሊትር", 125),
                Service(id = 913, "ስካይ ፈሳሽ ሳሙና", 100),
                Service(id = 914, "ጌሻ", 15),
                Service(id = 915, "ሃርሞኒ", 35),
                Service(id = 916, "ክሪስ ሎሽን ትልቁ", 200),
                Service(id = 917, "ተንጠልጣይ ሻምፖ", 10),
                Service(id = 918, "ኤቨርስት", 22),
                Service(id = 919, "ተንጠልጣይ ኦሞ ትንሹ", 15),
                Service(id = 920, "ኦርጋንዛ ትንሹ ኮንዲሽነር", 90),
                Service(id = 921, "ቦዲ ላይን ሎሽን ትንሹ", 30),
                Service(id = 922, "አቮካዶ ቅባት ትንሹ", 75),
                Service(id = 923, "ሶፍት ሎሽን ትንሹ", 120),
                Service(id = 924, "ሶፍት ቅባት ትንሹ", 90),
                Service(id = 925, "ወፍራም ኩል", 55),
                Service(id = 926, "ማጂክ ቻፕስቲክ", 35),
                Service(id = 927, "ላክስ ትልቁ ሳሙና", 100),
                Service(id = 928, "ሎላን በጸጉር ቀለም", 130),
                Service(id = 929, "ተንጠልጣይ ቫዝሊን", 10),
                Service(id = 930, "ቫዝሊን ሎሽን ትልቁ", 245),
                Service(id = 931, "መካከለኛ ቫዝሊን ሎሽን", 120),
                Service(id = 932, "ዚነት ትንሹ", 135),
                Service(id = 933, "ኢቭ ሞዴስ", 60),
                Service(id = 934, "ኦሊቭ የቆርቆሮ የወይራ ዘይት", 300),
                Service(id = 935, "ፎግ 2ኛው", 250),
                Service(id = 936, "ፎግ 1ኛው", 300),
                Service(id = 937, "ኮምፎርት ሞዴስ", 65),
                Service(id = 938, "ሲግናል 35 ግራም የጥርስ ሳሙና", 30),
                Service(id = 939, "ሲግናል 65 ግራም የጥርስ ሳሙና", 65),
                Service(id = 940, "የገላ ማሻ", 20),
                Service(id = 941, "ማምኮ ሶፍት", 45),
                Service(id = 942, "ማበጠሪያ ትልቁ", 20),
                Service(id = 943, "ባለመክፈያ ማበጠሪያ", 10),
                Service(id = 944, "ጥርስ ብሩሽ ትንሹ", 25),
                Service(id = 945, "ጥፍር መቁረጫ ትልቁ", 35),
                Service(id = 946, "ጥፍር መቁረጫ ትንሹ", 25),
                Service(id = 947, "የሎከር ቁልፍ ትልቁ", 90),
                Service(id = 948, "የሎከር ቁልፍ ትንሹ", 50),
                Service(id = 949, "የሻንጣ ቁልፍ", 35),
                Service(id = 950, "ሻወር ኬፕ", 55),
                Service(id = 951, "ምላጭ", 5),
                Service(id = 952, "ፋይን ሶፍት", 10),
                Service(id = 953, "ፋና ሶፍት", 10),
                Service(id = 954, "ጸጉር ማስያዣ", 15),
                Service(id = 955, "መስታውት ትንሹ", 25),
                Service(id = 956, "መቀስ ትንሹ", 20),
                Service(id = 957, "ካፑቺኖ ብስኩት", 10),
                Service(id = 958, "አቦለድ ብስኩት", 40),
                Service(id = 959, "ትሪደንት ማስቲካ", 15),
                Service(id = 960, "ኦርዮን ማስቲካ", 5),
                Service(id = 961, "ባናና ማስቲካ", 5),
                Service(id = 962, "ደስታ ከረሜላ", 2),
                Service(id = 963, "ጦር ማስቲካ", 5),
                Service(id = 964, "ፖፖቲን", 8),
                Service(id = 965, "ግሎሪ ብስኩት", 10),
                Service(id = 966, "ሚሪንዳ የፕላስቲክ", 50),
                Service(id = 967, "ፕሪጋት ትንሹ", 35),
                Service(id = 968, "የለውዝ ቅቤ ትንሹ", 100),
                Service(id = 969, "የለውዝ ቅቤ ትልቁ", 200),
                Service(id = 970, "ጆሊ ጁስ", 10),
                Service(id = 971, "ዉሃ 2 ሊትር", 30),
                Service(id = 972, "ዉሃ 1 ሊትር", 25),
                Service(id = 973, "ዉሃ ግማሽ ሊትር", 15),
                Service(id = 974, "ሊንክ ስክርቢቶ", 20),
                Service(id = 975, "ሌክሲ ስክርቢቶ", 20),
                Service(id = 976, "ቢክ ስክብሪቶ", 20),
                Service(id = 977, "ራዲየስ ስክርቢቶ", 20),
                Service(id = 978, "የታሸገ ባለ 50 ደብተር", 50),
                Service(id = 979, "ያልታሸገ ባለ 50 ደብተር", 40),
                Service(id = 980, "ባለ 5 ሳብጀክት ደብተር", 250),
                Service(id = 981, "ባለ 4 ሳብጀክት ደብተር", 200),
                Service(id = 982, "የታሸገ ባለ 32 ደብተር", 35),
                Service(id = 983, "ማስታወሻ ትንሹ ባለ 70 ሽት", 40),
                Service(id = 984, "ክራውን ኦሞ", 30),
                Service(id = 985, "አጃክስ ትንሹ", 10),
                Service(id = 986, "ክሪስ ሎሽን ትንሹ", 30),
                Service(id = 987, "የፕላስቲክ ለስላሳ መጠጦች ሁሉም አይነት", 45),
                Service(id = 988, "ማስ የገላ ሳሙና", 30),
                Service(id = 989, "አሞር የገላ ሳሙና", 60),
                Service(id = 990, "እርች የልብስ ሳሙና", 50),
                Service(id = 991, "ኦኬ የልብስ ሳሙና", 30),
                Service(id = 992, "ትልቁ ሰንላይት ኦሞ", 30),
                Service(id = 993, "ትልቁ ኦሞ ኦሞ", 35),
                Service(id = 994, "ትንሹ ኤርያል ኦሞ", 15),
                Service(id = 995, "ትንሹ ሮል ኦሞ", 15),
                Service(id = 996, "ማልታ የፕላስቲክ መጠጥ", 45),
                Service(id = 997, "ፕሪዴቶር ኢነርጂ መጠጥ", 40),
                Service(id = 998, "ጊፍት የገላ ሳሙና", 90)
            ),
            R.drawable.shop
       ),

        Category(
            id = 10,
            "የላውንደሪ አገልግሎቶች",
            services = listOf(
                Service(id = 1001, "ሱሪ", 10),
                Service(id = 1002, "ሸሚዝ", 8),
                Service(id = 1003, "ቀሚስ", 12),
                Service(id = 1004, "ጃኬት", 15),
                Service(id = 1005, "ቲሸርት", 8),
                Service(id = 1006, "ሱፍ", 60),
                Service(id = 1007, "አንሶላ ሁለት ጥንድ", 30),
                Service(id = 1008, "ጉርድ ቀሚስ", 10),
                Service(id = 1009, "ቦዲ", 5),
                Service(id = 1010, "ብርድ ልብስ ሲንግል ፌስ", 70),
                Service(id = 1011, "ብርድ ልብስ ዳብል ፌስ", 85),
                Service(id = 1012, "የአልጋ ፎጣ", 30)
            ),
            R.drawable.laundry
        ),

       Category(
            id = 11,
            "ጨዋታዎች",
            services = listOf(
                Service(id = 1101, "ፑል", 5),
                Service(id = 1102, "ቴኒስ", 5),
                Service(id = 1103, "ካራንቡላ", 5),
                Service(id = 1104, "ጆተኒ", 1)
            ),
            R.drawable.entertain
        ),

       Category(
            id = 12,
            "የፎቶ ኮፒና ተዛማጅ አገልግሎቶች",
            services = listOf(
                Service(id = 1201, "ኮፒ ለ1 ገጽ", 3),
                Service(id = 1202, "ፕሪንተር ለ1 ገጽ", 3),
                Service(id = 1203, "ላምኔት", 10),
                Service(id = 1204, "ባለ 6 ሪንግ", 16),
                Service(id = 1205, "ባለ 8 ሪንግ", 20),
                Service(id = 1206, "ባለ 12 ሪንግ", 25),
                Service(id = 1207, "ባለ 24 ሪንግ", 30),
                Service(id = 1208, "ላምኔት ሙሉ ወረቀት ኤ4", 20),
                Service(id = 1209, "2 ሳይድ ኮፒ", 5)
            ),
            R.drawable.photocopy
        ),

       Category(
            id = 13,
            "የሴቶች ጸጉር ቤት",
            services = listOf(
                Service(id = 1301, "እሳት ለመሰራት", 70),
                Service(id = 1302, "እሳት ለመደገም", 40),
                Service(id = 1303, "እሳት ሳብ ሳብ", 70),
                Service(id = 1304, "ፔስትራ", 70),
                Service(id = 1305, "ፔስትራ ሳብ ሳብ", 70),
                Service(id = 1306, "የዉሃ ከርል", 50),
                Service(id = 1307, "ካስክ", 50),
                Service(id = 1308, "ቅቤ መታጠብ", 40),
                Service(id = 1309, "ጸጉር ለመታጠብ", 30),
                Service(id = 1310, "ኖርማል በውሃ መድረቅ እና መለቀም", 50),
                Service(id = 1311, "ሻምፖ ለመጠቀም", 30),
                Service(id = 1312, "ፐርም ለመቀባት በእጅ", 30),
                Service(id = 1313, "ኮንዲሽነር ለመጠቀም", 30),
                Service(id = 1314, "ቀስር ለመጠቀም", 20),
                Service(id = 1315, "እስክራፕ ለመጠቀም", 20),
                Service(id = 1316, "ጥቁር ቀለም ለመቀባት በእጅ", 30),
                Service(id = 1317, "ሙሉ ብራውን ለመቀባት ", 50),
                Service(id = 1318, "ግማሽ ብራውን ለመቀባት", 50),
                Service(id = 1319, "ጸጉር ለመቁረጥ", 40),
                Service(id = 1320, "ሹርባ በጸጉር", 50),
                Service(id = 1321, "ቁጥርጥር በጸጉር", 60),
                Service(id = 1322, "ሹርባ በዊግ", 70),
                Service(id = 1323, "ቁጥርጥር በዊግ", 80),
                Service(id = 1324, "የጸጉር ስፌት", 140),
                Service(id = 1325, "ቅንድብ መቀንደብ", 10),
                Service(id = 1326, "የጸጉር ብሩሽ", 20),
                Service(id = 1327, "የጸጉር መክፈያ ማበጠሪያ", 10),
                Service(id = 1328, "የጸጉር ማስያዣ ትንሹ የፕላስቲክ", 15),
                Service(id = 1329, "ዊግ", 130)
            ),
            R.drawable.women
        ),

       Category(
            id = 14,
            "የወንዶች ጸጉር ቤት",
            services = listOf(
                Service(id = 1401, "ጸጉር ሙሉ", 50),
                Service(id = 1402, "ጸጉርና ጺም", 55),
                Service(id = 1403, "ጺም በቅርጽ", 30),
                Service(id = 1404, "ቅርጽ ብቻ", 30),
                Service(id = 1405, "ጺም", 25),
                Service(id = 1406, "ኖርማል ቁርጥ", 50),
                Service(id = 1407, "ቀለም መቀባት", 60),
                Service(id = 1408, "ስክራፕ", 30),
                Service(id = 1409, "እጥበት", 25)
            ),
            R.drawable.men
       )
    )
}
