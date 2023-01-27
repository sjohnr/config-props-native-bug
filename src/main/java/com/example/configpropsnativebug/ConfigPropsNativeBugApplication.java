package com.example.configpropsnativebug;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties(ConfigPropsNativeBugApplication.MyProps.class)
public class ConfigPropsNativeBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigPropsNativeBugApplication.class, args);
	}

	@Component
	public static class MyRunner implements CommandLineRunner {

		private final MyProps myProps;

		public MyRunner(MyProps myProps) {
			this.myProps = myProps;
		}

		@Override
		public void run(String... args) {
			System.out.println("myString=" + this.myProps.getMyString());
			System.out.println("myFlag=" + this.myProps.isMyFlag());
			System.out.println("anotherString=" + this.myProps.getNestedProps().getAnotherString());
			System.out.println("anotherFlag=" + this.myProps.getNestedProps().isAnotherFlag());
		}

	}

	@ConfigurationProperties("my.props")
	public static class MyProps {

		private String myString = "test";

		private boolean myFlag;

		private NestedProps nestedProps = new NestedProps();

		public String getMyString() {
			return this.myString;
		}

		public void setMyString(String myString) {
			this.myString = myString;
		}

		public boolean isMyFlag() {
			return this.myFlag;
		}

		public void setMyFlag(boolean myFlag) {
			this.myFlag = myFlag;
		}

		public NestedProps getNestedProps() {
			return this.nestedProps;
		}

		public void setNestedProps(NestedProps nestedProps) {
			this.nestedProps = nestedProps;
		}

	}

	public static class NestedProps {

		private String anotherString = "test";

		private boolean anotherFlag;

		public String getAnotherString() {
			return this.anotherString;
		}

		public void setAnotherString(String anotherString) {
			this.anotherString = anotherString;
		}

		public boolean isAnotherFlag() {
			return this.anotherFlag;
		}

		public void setAnotherFlag(boolean anotherFlag) {
			this.anotherFlag = anotherFlag;
		}

	}

}
