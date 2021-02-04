# About the Fork

**Goal: Have a working version of the Bazel Android Studio plugin. Share it with anyone else who might want it!**

We've forked only because we found we needed to apply bug fixes to get the plugin to work. Hopefully that's temporary; we'd be delighted to get these fixes into the main repo instead! Indeed, we tried to propose solutions there first, but haven't heard anything from the maintainers in a while--nor have most users, issues, or PRs, it seems. Maintainers, if you see this, we'd be delighted to delete this repo when the main one is back in working order.

In the meantime, we'll try to maintain this repo as a version of the plugin that works outside of Google. We'll have it automatically pull in the latest from the official repo. If you spot good fixes that unbreak key issues in the main repo but aren't being merged , we'd love it if you'd help keep the fork working by filing a PR or issue here. But new issues should go in the main repo!

## Key Issues Worked Around:
- Main repo uses a broken version of protobuf that prevents syncing: https://github.com/bazelbuild/intellij/issues/2265
- Compiler wrapper breaks C++/NDK autocomplete: https://github.com/bazelbuild/intellij/issues/2285

# An IntelliJ plugin for [Bazel](http://bazel.build) projects

## Installation

To use the fork, you'll have to build it from source--but that's easy and fast. See "Building the plugin," below. (Skip the GitHub releases and Jetbrains marketplace builds--those are from the main repo.)

Load it into the IDE via Preferences->Plugins->Gear->Install Plugin from Disk.

As a fast path, [here's my build for Android Studio](https://github.com/hedronvision/bazelbuild-intellij/releases/download/v2021.02.03/aswb_bazel.zip) (From February 3, 2021. Fixes things for me with Android Studio 4.1.2).

[If anyone wants to help with better distribution (binaries, CI, etc.) we'd love it!]

## Usage

To import an existing Bazel project, choose `Import Bazel Project`,
and follow the instructions in the project import wizard.

Detailed docs are available [here](http://ij.bazel.build).


## Building the plugin

Install Bazel, then build the target `*:*_bazel_zip` for your desired product:

* `bazel build //ijwb:ijwb_bazel_zip --define=ij_product=intellij-ue-oss-stable`
* `bazel build //clwb:clwb_bazel_zip --define=ij_product=clion-oss-stable`
* `bazel build //aswb:aswb_bazel_zip --define=ij_product=android-studio-oss-stable`

from the project root. This will create a plugin zip file at
`bazel-bin/<PRODUCT>/<PRODUCT>_bazel.zip`, which can be installed directly
from the IDE. `<PRODUCT>` can be one of `ijwb, clwb, aswb`.

If the IDE refuses to load the plugin because of version issues, specify the
correct `ij_product`. These are in the form `<IDE>-oss-<VERSION>` with 
  * `<IDE>` being one of `intellij-ue, intellij, clion, android-studio`, 
  * `<VERSION>` being one of `stable, beta, under-dev`.

If you are  using the most recent version of your IDE, you likely want
`--define=ij_product=<IDE>-beta` which will be the next version after
`<IDE>-latest`.  A complete mapping of all currently defined versions can
be found in  `intellij_platform_sdk/build_defs.bzl`.
