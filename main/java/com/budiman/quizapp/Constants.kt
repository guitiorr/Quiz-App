package com.budiman.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,"Wats dis?", R.drawable.bred, "Black Cat", "White Cat", "Orange Cat", "Car", 4
        )
        questionsList.add(que1)

        val que2 = Question(
            2,"Best String?", R.drawable.string, "Elixir", "Orphee", "Ernie's Balls", "D'Addario", 1
        )
        questionsList.add(que2)

        val que3 = Question(
            3,"Best Game?", R.drawable.ds, "Death Stranding", "CSGO", "Witcher 3", "Assassin's Creed 2", 3
        )
        questionsList.add(que3)

        val que4 = Question(
            4,"Idol?", R.drawable.cum, "Mario Camarena", "Ichika", "n-buna", "All above", 4
        )
        questionsList.add(que4)

        val que5 = Question(
            5,"Fav Color?", R.drawable.palet, "Red", "Blue", "Black", "Purple", 2
        )
        questionsList.add(que5)

        val que6 = Question(
            6,"Car Name?", R.drawable.cic, "Milo", "Pusi", "Cici", "Tom", 3
        )
        questionsList.add(que6)

        val que7 = Question(
            7,"Fav Genre?", R.drawable.genre, "Math Rock", "Progressive Rock", "Neo Soul", "J Rock", 1
        )
        questionsList.add(que7)

        val que8 = Question(
            8,"Fav Band?", R.drawable.chin, "CHON", "Polyphia", "Yorushika", "Murphy Radio", 1
        )
        questionsList.add(que8)

        val que9 = Question(
            9,"Fav Food?", R.drawable.fud, "Ayam Geprek", "Ramen", "Nasi Goreng", "Bakso", 4
        )
        questionsList.add(que9)


        return questionsList
    }

}