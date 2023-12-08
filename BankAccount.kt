class BankAccount(
    private val accountID: Int,
    private val accountName: String,
    private var currentBalance: Double
) {
    fun addFund(amount: Double): Boolean {
        if (currentBalance + amount < 0) return false
        currentBalance += amount
        return true
    }

    override fun toString(): String {
        return "Account $accountName ($accountID) : $currentBalance\n"
    }
}