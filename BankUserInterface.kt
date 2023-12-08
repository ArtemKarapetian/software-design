class BankUserInterface() {
    fun makeInterface() {
        println("You now have a variety of options in this Bank application")
        val bank = PersonalBank()
        while (true) {
            when (getOption()) {
                1 -> println(bank)
                2 -> addAccount(bank)
                3 -> addFund(bank)
                4 -> transfer(bank)
                5 -> return
            }
        }
    }
    
    private fun getOption(): Int {
        printOptions()
        do {
            val option = readLine()?.toIntOrNull()
            if (option != null && option in 1..5) return option
            println("Invalid option. Write integer in range from 1 to 5")
        } while (true)
    }
    
    private fun printOptions() {
        println("""
            Here are options to choose from
            1. Print all accounts
            2. Create account
            3. Add fund to account
            4. Transfer
            5. Exit
        """.trimIndent())
    }
    
    private fun addAccount(bank: PersonalBank) {
        bank.addAccount(getName())
        println("Account created")
    }
    
    private fun addFund(bank: PersonalBank) {
        val ID = getID()
        val amount = getAmount()
    
        val success = bank.addFundToAccount(ID, amount)
        when (success) {
            0 -> println("Added $amount to account with ID $ID")
            1 -> println("Account with ID $ID doesn't exist")
            2 -> println("Incorrect amount")
        }
    }
    
    private fun transfer(bank: PersonalBank) {
        val ID1 = getID()
        val ID2 = getID()
        val amount = getAmount()
    
        val success = bank.transfer(ID1, ID2, amount)
        when (success) {
            0 -> println("Transferred $amount from account with ID $ID1 to account with ID $ID2")
            1 -> println("Amount is negative")
            2 -> println("Account with ID $ID1 doesn't exist")
            3 -> println("Not enough money on account with ID $ID1")
            4 -> println("Account with ID $ID2 doesn't exist")
            5 -> println("O_o this was not planned. Perhaps, amount is negative")
        }
    }
    
    private fun getID(): Int {
        print("Write ID: ")
        do {
            val ID = readLine()?.toIntOrNull()
            if (ID != null) return ID
            println("Nah, incorrectly. Try one more time")
        } while (true)
    }
    
    private fun getName(): String {
        print("Write name of account: ")
        do {
            val name = readLine()
            if (name != null && name.isNotEmpty()) return name
            println("Invalid name. Write, at least, something")
        } while (true)
    }
    
    private fun getAmount(): Double {
        print("Write amount: ")
        do {
            val amount = readLine()?.toDoubleOrNull()
            if (amount != null && amount >= 0) return amount
            println("Nah, incorrectly. Try one more time")
        } while (true)
    }
}