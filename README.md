"# Final_Project_Automation_UI" 

```java
// Automatically detects GitHub Actions environment
String githubActions = System.getenv("GITHUB_ACTIONS");
if (githubActions != null && githubActions.equals("true")) {
// Headless mode configuration
options.addArguments("--headless=new");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
options.addArguments("--disable-gpu");
options.addArguments("--window-size=1920,1080");
}

// Cloudflare bypass (works in both local and CI)
options.addArguments("--disable-blink-features=AutomationControlled");
options.setExperimentalOption("useAutomationExtension", false);
```

### GitHub Actions Verification
- [ ] Workflow appears in Actions tab
- [ ] Workflow runs automatically on push
- [ ] Tests execute successfully
- [ ] Test reports uploaded as artifacts
- [ ] Test results show in PR checks

## 🐛 Common Issues & Solutions

### 1. **gradlew: Permission denied**
```bash
chmod +x gradlew
```

### 2. **gradlew file not found**
```bash
gradle wrapper --gradle-version=8.5
```

### 3. **GitHub Actions fails: "No tests found"**
- Verify suite file path in `build.gradle.kts`
- Check suite file exists: `ls -la src/test/resources/suites/smoke.xml`
- Ensure test classes have `@Test` annotation

### 4. **Chrome not found in CI**
- Workflow already includes Chrome installation step
- Verify `.github/workflows/ci.yml` has `browser-actions/setup-chrome@v1`

### 5. **Tests pass locally but fail in CI**
- Add more wait time for headless mode
- Check window size: `--window-size=1920,1080`
- Review CI test reports in artifacts
- Add explicit waits instead of Thread.sleep

---
