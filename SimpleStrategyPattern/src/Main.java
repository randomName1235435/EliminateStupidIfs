import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) throws Exception {
		Message result;
		result = ProcessNoPattern();
		result = ProcessStrategyPattern();
		result = ProcessStrategyPatternMethodPointer();

	}

	private static Message ProcessStrategyPatternMethodPointer() {
		Supplier<Message> createMessage = () -> {
			return new Message("success");
		};

		// reallife sample
		try {
			short ag = toShort("Sample");
		} catch (Exception except) {
			createMessage = () -> {
				return new Message("failed");
			};
		}

		try {
			short menge = toShort("SecondSample");
		} catch (Exception except) {
			createMessage = () -> {
				return new Message("failed");
			};
		}
		return createMessage.get();
	}

	private static Message ProcessStrategyPattern() {
		MessageCreator messageCreator = new SuccessMessageCreator();

		// reallife sample
		try {
			short ag = toShort("Sample");
		} catch (Exception except) {
			messageCreator = new FailesMessagedCreator();
		}

		try {
			short menge = toShort("SecondSample");
		} catch (Exception except) {
			messageCreator = new FailesMessagedCreator();
		}

		return messageCreator.create();
	}

	private static Message ProcessNoPattern() {
		boolean result = false;

		// reallife sample
		try {
			short ag = toShort("Sample");
		} catch (Exception except) {
			result = false;
		}

		try {
			short menge = toShort("SecondSample");
		} catch (Exception except) {
			result = false;
		}

		if (result) {
			return new Message("success");
		} else {
			return new Message("failed");
		}
	}

	private static boolean getResult() {
		return false;
	}

	public static short toShort(String text) throws Exception {
		if (text != null && text.length() != 0)
			return (Short.parseShort(text.trim()));
		else
			return (0);

	} // toShort
}
