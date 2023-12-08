class PersonalBank(){
    private val accounts: MutableList<BankAccount> = mutableListOf()
    private var counter: Int = 0

    fun addAccount(name: String) {
        accounts.add(BankAccount(++counter, name, 0.0))
    }

    fun addFundToAccount(id: Int, amount: Double): Int {
        if (id > counter || id <= 0)
            return 1
        if (!accounts[id - 1].addFund(amount))
            return 2
        return 0
    }

    fun transfer(id1: Int, id2: Int, amount: Double): Int {
        if (amount < 0)
            return 1
        val success_1 = addFundToAccount(id1, -amount)
        if (success_1 != 0)
            return success_1 + 1
        val success_2 = addFundToAccount(id2, amount)
        if (success_2 != 0) {
            addFundToAccount(id1, amount)
            return success_2 + 3
        }
        return 0
    }

    override fun toString(): String {
        var output = "Info about all accounts in Bank:"

        if (accounts.isEmpty()) {
            output += "\nThere are no accounts in bank :("
            return output
        }
        accounts.forEach { account ->
            output += '\n'
            output += account.toString()
        }

        return output;
    }
}
