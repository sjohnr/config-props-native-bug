config-props-native-bug
==

**Steps to reproduce:**

1. `sdk env` (requires [SDKMAN!](https://sdkman.io/usage))
2. `./gradlew nativeCompile`
3. `./build/native/nativeCompile/config-props-native-bug`

**Expected output:**

```
myString=string
myFlag=true
anotherString=test
anotherFlag=true
```

**Actual output:**

```
myString=string
myFlag=true
anotherString=test
anotherFlag=false
```
