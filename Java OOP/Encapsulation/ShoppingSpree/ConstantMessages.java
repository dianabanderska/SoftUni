package ShoppingSpree;

public enum ConstantMessages {

     INVALID_NAME_EXCEPTION_MESSAGE ("Name cannot be empty"),

     NEGATIVE_MONEY_EXCEPTION_MESSAGE ("Money cannot be negative");

     private String message;

      ConstantMessages(String message) {
          this.message = message;
     }

     public String getMessage() {
          return message;
     }
}
