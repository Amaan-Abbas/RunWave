# 🏃 Running Tracker App

A modern Android running tracker built with **Kotlin**, **Jetpack Compose**, and **MVP architecture**.  
The app helps users track runs, monitor progress, and stay motivated with milestone achievements.

---

## 📱 Features (MVP)

### 🔐 Authentication
- Phone OTP login
- Email & password login
- Persistent sessions
- Secure UID-based identity

---

### 🧭 Onboarding
1. Intro slides (app overview)
2. Login
3. Goal selection (lightweight)
4. Main screen

---

### 🎯 Goal Selection
Users can select a primary goal:
- Stay active
- Improve distance
- Train for 5K

Stored for future personalization.

---

### 🏠 Main Screen
- Start Run
- Destination Run
- Weekly distance & total runs (quick stats)
- Profile completion banner (optional)
- Navigation drawer:
  - History
  - Challenges
  - Settings

---

## 🏃 Run Tracking

### Live Tracking
- GPS-based route tracking
- Distance & time (live)
- Pause / Resume
- **Hold to Stop** (prevents accidental taps)

---

### 🧭 Destination Mode
Run toward a selected point on the map.

✔ Tap map to choose destination  
✔ Shows distance to destination  
✔ Tracks distance remaining  

> Note: No navigation or routing in MVP.

---

### 🏁 Run Summary
After completing a run:

- Route outline
- Total distance
- Duration
- Average pace
- Calories (estimated)

---

## 📜 Run History

### History Screen
- List of past runs
- Date, distance, duration

### Run Details
- Route map
- Distance & duration
- Avg pace
- Calories
- Start & end time

---

## 🏅 Personal Challenges (Milestones)

Offline achievement system based on user activity.

### Included Milestones
- Distance milestones (10 km, 50 km, 100 km)
- Run count milestones (5, 20, 50 runs)
- Longest run milestones

---

## 📊 Stats

### Main Screen (Minimal)
- Weekly distance
- Total runs

### Detailed Stats Screen
- Total distance
- Avg pace
- Longest run
- Total run time
- Calories (optional)

---

## 👤 Progressive Profile Completion
Users can complete their profile later via banner.

### Future-ready fields
- Name
- Weight
- Goal

---

## ⚙️ Settings

### Profile
- Edit profile

### Preferences
- Units (km / miles)
- Theme (Light / Dark / System)

### Account
- Logout

---

## 🏗️ Architecture

**Pattern:** MVP (Model–View–Presenter)

