package de.rewe.coiltest

class OfferFactory {
    companion object {
        fun getOffers(): List<Offer> = listOf(
            Offer("1", "Offer 1", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/4532023/31434352-6_digital-image.png"),
            Offer("2", "Offer 2", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/1056372/22943110-22_digital-image.png"),
            Offer("3", "Offer 3", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/0315192/2974400-88_digital-image.png"),
            Offer("4", "Offer 4", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/0316326/2551270-53_digital-image.png"),
            Offer("5", "Offer 5", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/8177488/28019617-4_digital-image.png"),
            Offer("6", "Offer 6", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/3205683/26249648-15_digital-image.png"),
            Offer("7", "Offer 7", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/2755945/25785275-14_digital-image.png"),
            Offer("8", "Offer 8", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/2759072/25587077-10_digital-image.png"),
            Offer("9", "Offer 9", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/7229050/27552809-10_digital-image.png"),
            Offer("10", "Offer 10", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/7206722/27552807-13_digital-image.png"),
            Offer("11", "Offer 11", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/2344381/23413381-27_digital-image.png"),
            Offer("12", "Offer 12", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/8424002/30981616-4_digital-image.png"),
            Offer("13", "Offer 13", "Offer Address", "https://img.rewe-static.de/KLEIN43_2020/8305721/30072945-7_digital-image.png"),
        )
    }
}