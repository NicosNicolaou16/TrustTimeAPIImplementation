# Trust Time API Implementation

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This repository explores the implementation of Google's new **TrustedTime API**. It provides a reliable approach to timekeeping for Android apps, preventing issues caused by users manually changing their device clock.

> [!IMPORTANT]  
> Read the full technical article here:  
> 👉 **[Trusted Time API Implementation - Medium](https://medium.com/@nicosnicolaou/trusted-time-api-implementation-7f3c6c14809c)** 👈

## ✨ Key Features

*   **Dual Implementation:** Provides two distinct approaches for integration:
    *   **With Dependency Injection:** Clean implementation using **Hilt**.
    *   **Standard Implementation:** Direct usage for simpler projects.
*   **Modern Stack:** Built using the latest Android development standards (SDK 36).
*   **Reliable Time:** Demonstrates how to fetch a timestamp that is independent of the user's system clock settings.

## 🛠️ Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
- **API:** [Google TrustedTime API](https://android-developers.googleblog.com/2025/02/trustedtime-api-introducing-reliable-approach-to-time-keeping-for-apps.html)

## 🔧 Versioning

- **Target SDK:** `36`
- **Minimum SDK:** `29`
- **Kotlin Version:** `2.3.10`
- **Gradle Version:** `9.1.0`

## 📚 References

- **Official Announcement:** [Introducing a reliable approach to time-keeping for apps](https://android-developers.googleblog.com/2025/02/trustedtime-api-introducing-reliable-approach-to-time-keeping-for-apps.html)


This repository explores the implementation of Google's new Trust Time API. We provide two
approaches for integrating the API: one with Dependency Injection and one without. Whether you're
looking to understand the core concept or implement it
yourself, this guide will walk you through each method step by step.

> [!IMPORTANT]  
> Check my article :point_right: [Trusted Time API Implementation - Medium](https://medium.com/@nicosnicolaou/trusted-time-api-implementation-7f3c6c14809c) :point_left: <br />

# Versioning

Target SDK version: 36 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.3.10 <br />
Gradle version: 9.1.0 <br />

# References

https://android-developers.googleblog.com/2025/02/trustedtime-api-introducing-reliable-approach-to-time-keeping-for-apps.html