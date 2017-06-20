## 启动：
* 启动consul 
`consul agent -dev`
* 启动service
`./gradlew clean bootRun`

## 访问
* 访问consul ui
`http://localhost:8500/ui/#/dc1/services`
* 访问service
`http://localhostt:8502/wanzi?name=Yu`