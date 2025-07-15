import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

init() {
    KoinEntryPoint.initKoinIos()
}

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}