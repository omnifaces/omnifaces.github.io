[Download](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.7.1/omnifaces-4.7.1.jar) - [Showcase](https://showcase.omnifaces.org) - [API docs](https://omnifaces.org/docs/javadoc/current/) - [VDL docs](https://omnifaces.org/docs/vdldoc/current/) - [GitHub](https://github.com/omnifaces/omnifaces) - [Issues](https://github.com/omnifaces/omnifaces/issues) - [X](https://x.com/OmniFaces)


## What is OmniFaces?

Tired of reinventing `JSFUtils` or `FacesUtils` utility classes for every JSF / Jakarta Faces web application and/or homebrewing custom components, taghandlers, etc to workaround or enhance some general shortcomings in Faces? OmniFaces may be what you're looking for!

OmniFaces is a **utility library** for Faces that focusses on utilities that ease everyday tasks with the standard Faces API. OmniFaces is a response to frequently recurring problems encountered during ages of professional Faces development and from questions being asked on [Stack Overflow](http://stackoverflow.com).

Contrary to some of the other excellent Faces component libraries out there (like [PrimeFaces](http://primefaces.org), [BootsFaces](http://bootsfaces.net), or [ButterFaces](http://butterfaces.org)), OmniFaces does not contain any of the beautiful visually oriented components that those other libraries are already known and loved for. As such, OmniFaces does not and will never contain things like rich table components or tasty look'n'feels. OmniFaces is more geared toward "utilities" that solve everyday practical problems and workarounds for (small) shortcomings in the Faces API. Such utilities and workarounds can be based on components, but OmniFaces does not necessarily strive to be a "component library" perse. OmniFaces can just be used together with any component library.

Besides utility classes for working with the Faces API from Java code, such as [Faces](https://showcase.omnifaces.org/utils/Faces) and [Messages](https://showcase.omnifaces.org/utils/Messages), and utility and enhanced components, such as [&lt;o:highlight&gt;](https://showcase.omnifaces.org/components/highlight) and [&lt;o:viewParam&gt;](https://showcase.omnifaces.org/components/viewParam), OmniFaces will include various general converters, validators and Facelets tag handlers. These will range from ["all-or-none" validators](https://showcase.omnifaces.org/validators/validateAllOrNone) to [automatic &lt;f:selectItem(s)&gt; converters](https://showcase.omnifaces.org/converters/SelectItemsConverter). There are also specialized handlers, such as a [full ajax exception handler](https://showcase.omnifaces.org/exceptionhandlers/FullAjaxExceptionHandler) and a [combined resource handler](https://showcase.omnifaces.org/resourcehandlers/CombinedResourceHandler). CDI specific features are available such as transparent support for injection in [@FacesConverter](https://showcase.omnifaces.org/cdi/FacesConverter) and [@FacesValidator](https://showcase.omnifaces.org/cdi/FacesValidator), an improved [@ViewScoped](https://showcase.omnifaces.org/cdi/ViewScoped) which immediately destroys on unload, and web socket based push via [&lt;o:socket&gt;](https://showcase.omnifaces.org/push/socket). For a full overview of what's all available in OmniFaces and several live examples, look at the [showcase](https://showcase.omnifaces.org).


## Minimum requirements

An important design goal will be to have as few dependencies as possible and to be minimally invasive.

- OmniFaces 5.x requires Java 17, Faces 4.1, EL 6.0, Servlet 6.1, CDI 4.1, WS 2.2
- OmniFaces 4.x requires Java 11, Faces 3.0, EL 4.0, Servlet 5.0, CDI 3.0, WS 2.0
- OmniFaces 3.x requires Java 1.8, JSF 2.3, EL 3.0, Servlet 3.1, CDI 2.0, WS 1.1
- OmniFaces 2.x requires Java 1.7, JSF 2.2, EL 2.2, Servlet 3.0, CDI 1.1, WS 1.1
- OmniFaces 1.x requires Java 1.6, JSF 2.0, EL 2.1, Servlet 2.5

Since OmniFaces 1.6 there was an *optional* dependency on CDI, which turned out to be troublesome in some outdated environments, so they were since version 1.10 removed from version 1.x for a better compatibility with those environments. The CDI specific features remain in version 2.x whereby the CDI dependency is thus made [required](https://omnifaces.org/cdi). Version 1.x users who are already using CDI specific features on a JSF 2.1 environment should be able to effortlessly migrate to version 2.x. OmniFaces 2.0/2.1 is unofficially backwards compatible with JSF 2.1. OmniFaces 2.2 is not anymore backwards compatible with JSF 2.1.

Since OmniFaces 2.3 there is a *required* dependency on JSR356 WebSocket which is already available in any Java EE 7 container and in even earlier versions of servletcontainers (Tomcat supports it since 7.0.27 and Jetty supports it since 9.1.0).

While OmniFaces 4.x requires Faces 3.0, it is fully compatible with Faces 4.0 and 4.1.

All OmniFaces versions have an *optional* dependency on JSR303 Bean Validation which is only required when you start to actually use `<o:validateBean>` or `JsfLabelMessageInterpolator`.

OmniFaces should principally integrate perfectly well with most other Faces component libraries. Even more, the [OmniFaces showcase application](https://showcase.omnifaces.org) uses PrimeFaces. If you encounter problems in combination with a specific component library, then by all means report an [issue](https://github.com/omnifaces/omnifaces/issues). We'll investigate if it's caused by OmniFaces or the component library in question and fix it or propose a workaround solution, depending on the nature of the problem. Note that OmniFaces is due to the mandatory Servlet API dependency **not** compatible with portlets.


## Installation

It is a matter of dropping the [OmniFaces 4.7.1 JAR file](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.7.1/) in `/WEB-INF/lib`.

Maven users can add OmniFaces by adding the following Maven coordinates to `pom.xml` of the WAR project:

```XML
<dependency>
    <groupId>org.omnifaces</groupId>
    <artifactId>omnifaces</artifactId>
    <version>4.7.1</version>
</dependency>
```

Or when you're using JSF 2.3, pick [OmniFaces 3.14.12](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.14.12/): 

```XML
<dependency>
    <groupId>org.omnifaces</groupId>
    <artifactId>omnifaces</artifactId>
    <version>3.14.12</version>
</dependency>
```

The 3.x branch is in maintenance mode. New things won't be added there. For users who are still on JSF 2.2, use [2.7.30](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.7.30/) instead. The 2.x branch is also in maintenance mode. I.e. it'll also only receive bugfixes. For users on yet more outdated environments who can't/won't use CDI, use [1.14.1](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.14.1/) instead. It doesn't contain anything from CDI nor new things which were added in 2.x, but it does contain enhancements and bugfixes to existing 1.x things. Note that there is no 1.15 nor 1.16. The 1.14.1 is latest version of the 1.x branch which is in securityfix mode. I.e. it'll only receive security fixes.

The OmniFaces UI components/taghandlers and EL functions are available under the following XML namespaces:

```XML
xmlns:o="http://omnifaces.org/ui"
xmlns:of="http://omnifaces.org/functions"
```

Since OmniFaces 5.0 (currently only available as milestone release, with [5.0-M6](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/5.0-M6/) as latest), these are available under a single XML namespace:

```XML
xmlns:o="omnifaces"
```

OmniFaces is designed as a WAR library (web fragment library) and therefore can't be placed elsewhere in the webapp's runtime classpath outside WAR's own `/WEB-INF/lib`, such as EAR's `/lib` or even server's or JRE's own `/lib`. When OmniFaces JAR file is misplaced this way, then the webapp will be unable to find OmniFaces-bundled Faces/CDI annotated classes and throw exceptions related to this during deploy or runtime. To solve it, put back  OmniFaces in WAR's `/WEB-INF/lib`. Also note that you shouldn't have duplicate OmniFaces JAR files, otherwise CDI will throw exceptions related to ambiguous dependencies during deploy.


## Download

Version history can be found in "[What's new](https://showcase.omnifaces.org/whatsnew)" page at the showcase.

### OmniFaces 4.x

**Required**: Java 11, Faces 3.0, EL 4.0, Servlet 5.0, CDI 3.0, WS 2.0  
**Optional**: BV 3.0

- 4.7.1 (6 Dec 2025) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.7.1/omnifaces-4.7.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.7.1/omnifaces-4.7.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.7.1/omnifaces-4.7.1-javadoc.jar)
- 4.6.5 (8 Jun 2025) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.6.5/omnifaces-4.6.5.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.6.5/omnifaces-4.6.5-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.6.5/omnifaces-4.6.5-javadoc.jar)
- 4.5.1 (2 Sep 2024) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.5.1/omnifaces-4.5.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.5.1/omnifaces-4.5.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.5.1/omnifaces-4.5.1-javadoc.jar)
- 4.4.1 (5 May 2024) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.4.1/omnifaces-4.4.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.4.1/omnifaces-4.4.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.4.1/omnifaces-4.4.1-javadoc.jar)
- 4.3 (23 Sep 2023) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.3/omnifaces-4.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.3/omnifaces-4.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.3/omnifaces-4.3-javadoc.jar)
- 4.2 (24 Jun 2023) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.2/omnifaces-4.2.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.2/omnifaces-4.2-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.2/omnifaces-4.2-javadoc.jar)
- 4.1 (26 Feb 2023) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.1/omnifaces-4.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.1/omnifaces-4.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.1/omnifaces-4.1-javadoc.jar)
- 4.0.1 (21 Nov 2022) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.0.1/omnifaces-4.0.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.0.1/omnifaces-4.0.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/4.0.1/omnifaces-4.0.1-javadoc.jar)

### OmniFaces 3.x

**Required**: Java 1.8, JSF 2.3, EL 3.0, Servlet 3.1, CDI 2.0, WS 1.1  
**Optional**: BV 2.0  

- 3.14.12 (9 Nov 2025) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.14.12/omnifaces-3.14.12.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.14.12/omnifaces-3.14.12-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.14.12/omnifaces-3.14.12-javadoc.jar)
- 3.13.4 (14 Aug 2022) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.13.4/omnifaces-3.13.4.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.13.4/omnifaces-3.13.4-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.13.4/omnifaces-3.13.4-javadoc.jar)
- 3.12 (15 Nov 2021) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.12/omnifaces-3.12.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.12/omnifaces-3.12-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.12/omnifaces-3.12-javadoc.jar)
- 3.11.2 (15 Oct 2021) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.11.2/omnifaces-3.11.2.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.11.2/omnifaces-3.11.2-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.11.2/omnifaces-3.11.2-javadoc.jar)
- 3.10.1 (24 Jan 2021) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.10.1/omnifaces-3.10.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.10.1/omnifaces-3.10.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.10.1/omnifaces-3.10.1-javadoc.jar)
- 3.9 (19 Dec 2020) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.9/omnifaces-3.9.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.9/omnifaces-3.9-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.9/omnifaces-3.9-javadoc.jar)
- 3.8.1 (25 Oct 2020) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.8.1/omnifaces-3.8.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.8.1/omnifaces-3.8.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.8.1/omnifaces-3.8.1-javadoc.jar)
- 3.7.1 (12 Jul 2020) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.7.1/omnifaces-3.7.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.7.1/omnifaces-3.7.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.7.1/omnifaces-3.7.1-javadoc.jar)
- 3.6.1 (22 May 2020) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.6.1/omnifaces-3.6.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.6.1/omnifaces-3.6.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.6.1/omnifaces-3.6.1-javadoc.jar)
- 3.5 (12 Apr 2020) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.5/omnifaces-3.5.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.5/omnifaces-3.5-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.5/omnifaces-3.5-javadoc.jar)
- 3.4.1 (30 Nov 2019) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.4.1/omnifaces-3.4.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.4.1/omnifaces-3.4.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.4.1/omnifaces-3.4.1-javadoc.jar)
- 3.3 (5 May 2019) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.3/omnifaces-3.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.3/omnifaces-3.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.3/omnifaces-3.3-javadoc.jar)
- 3.2 (29 Jul 2018) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.2/omnifaces-3.2.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.2/omnifaces-3.2-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.2/omnifaces-3.2-javadoc.jar)
- 3.1 (12 Apr 2018) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.1/omnifaces-3.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.1/omnifaces-3.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.1/omnifaces-3.1-javadoc.jar)
- 3.0 (3 Jan 2018) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.0/omnifaces-3.0.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.0/omnifaces-3.0-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/3.0/omnifaces-3.0-javadoc.jar)

### OmniFaces 2.x

**Required**: Java 1.7, JSF 2.2, EL 2.2, Servlet 3.0, CDI 1.1 and since 2.3 WS 1.1  
**Optional**: BV 1.1  

- 2.7.30 (9 Nov 2025) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.7.30/omnifaces-2.7.30.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.7.30/omnifaces-2.7.30-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.7.30/omnifaces-2.7.30-javadoc.jar)
- 2.6.9 (12 Apr 2018) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.6.9/omnifaces-2.6.9.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.6.9/omnifaces-2.6.9-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.6.9/omnifaces-2.6.9-javadoc.jar)
- 2.5.1 (21 Sep 2016) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.5.1/omnifaces-2.5.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.5.1/omnifaces-2.5.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.5.1/omnifaces-2.5.1-javadoc.jar)
- 2.4 (1 Jul 2016) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.4/omnifaces-2.4.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.4/omnifaces-2.4-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.4/omnifaces-2.4-javadoc.jar)
- 2.3 (1 Apr 2016) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.3/omnifaces-2.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.3/omnifaces-2.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.3/omnifaces-2.3-javadoc.jar)
- 2.2 (24 Nov 2015) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.2/omnifaces-2.2.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.2/omnifaces-2.2-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.2/omnifaces-2.2-javadoc.jar)
- 2.1 (3 Jun 2015) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.1/omnifaces-2.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.1/omnifaces-2.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.1/omnifaces-2.1-javadoc.jar)
- 2.0 (24 Nov 2014) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.0/omnifaces-2.0.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.0/omnifaces-2.0-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/2.0/omnifaces-2.0-javadoc.jar)

### OmniFaces 1.1x

**Required**: Java 1.6, JSF 2.0, EL 2.1, Servlet 2.5  
**Optional**: BV 1.0  

- 1.14.1 (20 May 2017) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.14.1/omnifaces-1.14.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.14.1/omnifaces-1.14.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.14.1/omnifaces-1.14.1-javadoc.jar)
- 1.13 (1 Apr 2016) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.13/omnifaces-1.13.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.13/omnifaces-1.13-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.13/omnifaces-1.13-javadoc.jar)
- 1.12.1 (26 Nov 2015) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.12.1/omnifaces-1.12.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.12.1/omnifaces-1.12.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.12.1/omnifaces-1.12.1-javadoc.jar)
- 1.11 (3 Jun 2015) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.11/omnifaces-1.11.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.11/omnifaces-1.11-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.11/omnifaces-1.11-javadoc.jar)
- 1.10 (24 Nov 2014) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.10/omnifaces-1.10.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.10/omnifaces-1.10-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.10/omnifaces-1.10-javadoc.jar)

### OmniFaces 1.x

**Required**: Java 1.6, JSF 2.0, EL 2.1, Servlet 2.5  
**Optional**: BV 1.0 and since 1.6 CDI 1.0

- 1.8.3 (3 Jun 2015) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.8.3/omnifaces-1.8.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.8.3/omnifaces-1.8.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.8.3/omnifaces-1.8.3-javadoc.jar)
- 1.7 (12 Jan 2014) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.7/omnifaces-1.7.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.7/omnifaces-1.7-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.7/omnifaces-1.7-javadoc.jar)
- 1.6.3 (18 Oct 2013) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.6.3/omnifaces-1.6.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.6.3/omnifaces-1.6.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.6.3/omnifaces-1.6.3-javadoc.jar)
- 1.5 (10 Jun 2013) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.5/omnifaces-1.5.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.5/omnifaces-1.5-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.5/omnifaces-1.5-javadoc.jar)
- 1.4.1 (12 Mar 2013) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.4.1/omnifaces-1.4.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.4.1/omnifaces-1.4.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.4.1/omnifaces-1.4.1-javadoc.jar)
- 1.3 (20 Dec 2012) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.3/omnifaces-1.3.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.3/omnifaces-1.3-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.3/omnifaces-1.3-javadoc.jar)
- 1.2 (20 Oct 2012) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.2/omnifaces-1.2.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.2/omnifaces-1.2-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.2/omnifaces-1.2-javadoc.jar)
- 1.1 (10 Jul 2012) - [library](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.1/omnifaces-1.1.jar) - [sources](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.1/omnifaces-1.1-sources.jar) - [javadoc](https://repo.maven.apache.org/maven2/org/omnifaces/omnifaces/1.1/omnifaces-1.1-javadoc.jar)
- 1.0 (1 Jun 2012) - [library](https://omnifaces.org/downloads/omnifaces-1.0.jar) - [sources](https://omnifaces.org/downloads/omnifaces-1.0-sources.jar)

<!--
## Snapshot

If you like to play around with the newest of the newest, hereby accepting the risk that new classes/methods may be moved/renamed without notice, then grab the [3.0-SNAPSHOT](https://oss.sonatype.org/content/repositories/snapshots/org/omnifaces/omnifaces/3.0-SNAPSHOT/) instead.

Maven users can add OmniFaces SNAPSHOT by adding the following Maven coordinates to pom.xml:

```XML
<repositories>
    <repository>
        <id>oss.sonatype.org-snapshot</id>
        <url>http://oss.sonatype.org/content/repositories/snapshots</url>
        <releases><enabled>false</enabled></releases>
        <snapshots><enabled>true</enabled></snapshots>
    </repository>
</repositories>
<dependencies>
    <dependency>
        <groupId>org.omnifaces</groupId>
        <artifactId>omnifaces</artifactId>
        <version>3.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

For starters, a "snapshot" is just the current/latest build. It's far from a release. We may make code changes and create snapshots so now and then before final version release. Those changes will then get reflected in your project if you use the snapshot version in your Maven project and forces an update. It will generally work just fine, but imagine if we make some mistake and notice it only a few days or weeks later, or are trying to test something which may not necessarily work in all environments, then your project may be affected. That's why it's advisable to not use snapshots of 3rd party libraries in production, unless you have your own build system which can "lock" a specific snapshot version, or closely track (and understand) any changes in the codebase. See also a.o. [What exactly is a Maven snapshot?](https://stackoverflow.com/q/5901378/157882).
-->

## Documentation

 * [OmniFaces API documentation](https://omnifaces.org/docs/javadoc/current/)
   - [4.7](https://omnifaces.org/docs/javadoc/4.7/) - [4.6](https://omnifaces.org/docs/javadoc/4.6/) - [4.5](https://omnifaces.org/docs/javadoc/4.5/) - [4.4](https://omnifaces.org/docs/javadoc/4.4/) - [4.3](https://omnifaces.org/docs/javadoc/4.3/) - [4.2](https://omnifaces.org/docs/javadoc/4.2/) - [4.1](https://omnifaces.org/docs/javadoc/4.1/) - [4.0](https://omnifaces.org/docs/javadoc/4.0/)
   - [3.14](https://omnifaces.org/docs/javadoc/3.14/) - [3.13](https://omnifaces.org/docs/javadoc/3.13/) - [3.12](https://omnifaces.org/docs/javadoc/3.12/) - [3.11](https://omnifaces.org/docs/javadoc/3.11/) - [3.10](https://omnifaces.org/docs/javadoc/3.10/) - [3.9](https://omnifaces.org/docs/javadoc/3.9/) - [3.8](https://omnifaces.org/docs/javadoc/3.8/) - [3.7](https://omnifaces.org/docs/javadoc/3.7/) - [3.6](https://omnifaces.org/docs/javadoc/3.6/) - [3.5](https://omnifaces.org/docs/javadoc/3.5/) - [3.4](https://omnifaces.org/docs/javadoc/3.4/) - [3.3](https://omnifaces.org/docs/javadoc/3.3/) - [3.2](https://omnifaces.org/docs/javadoc/3.2/) - [3.1](https://omnifaces.org/docs/javadoc/3.1/) - [3.0](https://omnifaces.org/docs/javadoc/3.0/) 
   - [2.7](https://omnifaces.org/docs/javadoc/2.7/) - [2.6](https://omnifaces.org/docs/javadoc/2.6/) - [2.5](https://omnifaces.org/docs/javadoc/2.5/) - [2.4](https://omnifaces.org/docs/javadoc/2.4/) - [2.3](https://omnifaces.org/docs/javadoc/2.3/) - [2.2](https://omnifaces.org/docs/javadoc/2.2/) - [2.1](https://omnifaces.org/docs/javadoc/2.1/) - [2.0](https://omnifaces.org/docs/javadoc/2.0/) 
   - [1.14](https://omnifaces.org/docs/javadoc/1.14/) - [1.13](https://omnifaces.org/docs/javadoc/1.13/) - [1.12](https://omnifaces.org/docs/javadoc/1.12/) - [1.11](https://omnifaces.org/docs/javadoc/1.11/) - [1.10](https://omnifaces.org/docs/javadoc/1.10/)
   - [1.8](https://omnifaces.org/docs/javadoc/1.8/) - [1.7](https://omnifaces.org/docs/javadoc/1.7/) - [1.6](https://omnifaces.org/docs/javadoc/1.6/) - [1.5](https://omnifaces.org/docs/javadoc/1.5/) - [1.4](https://omnifaces.org/docs/javadoc/1.4/) - [1.3](https://omnifaces.org/docs/javadoc/1.3/) - [1.2](https://omnifaces.org/docs/javadoc/1.2/) - [1.1](https://omnifaces.org/docs/javadoc/1.1/) - [1.0](https://omnifaces.org/docs/javadoc/1.0/)
 * [OmniFaces VDL documentation](https://omnifaces.org/docs/vdldoc/current/)
   - [4.7](https://omnifaces.org/docs/vdldoc/4.7/) - [4.6](https://omnifaces.org/docs/vdldoc/4.6/) - [4.5](https://omnifaces.org/docs/vdldoc/4.5/) - [4.4](https://omnifaces.org/docs/vdldoc/4.4/) - [4.3](https://omnifaces.org/docs/vdldoc/4.3/) - [4.2](https://omnifaces.org/docs/vdldoc/4.2/) - [4.1](https://omnifaces.org/docs/vdldoc/4.1/) - [4.0](https://omnifaces.org/docs/vdldoc/4.0/)
   - [3.14](https://omnifaces.org/docs/vdldoc/3.14/) - [3.13](https://omnifaces.org/docs/vdldoc/3.13/) - [3.12](https://omnifaces.org/docs/vdldoc/3.12/) - [3.11](https://omnifaces.org/docs/vdldoc/3.11/) - [3.10](https://omnifaces.org/docs/vdldoc/3.10/) - [3.9](https://omnifaces.org/docs/vdldoc/3.9/) - [3.8](https://omnifaces.org/docs/vdldoc/3.8/) - [3.7](https://omnifaces.org/docs/vdldoc/3.7/) - [3.6](https://omnifaces.org/docs/vdldoc/3.6/) - [3.5](https://omnifaces.org/docs/vdldoc/3.5/) - [3.4](https://omnifaces.org/docs/vdldoc/3.4/) - [3.3](https://omnifaces.org/docs/vdldoc/3.3/) - [3.2](https://omnifaces.org/docs/vdldoc/3.2/) - [3.1](https://omnifaces.org/docs/vdldoc/3.1/) - [3.0](https://omnifaces.org/docs/vdldoc/3.0/) 
   - [2.7](https://omnifaces.org/docs/vdldoc/2.7/) - [2.6](https://omnifaces.org/docs/vdldoc/2.6/) - [2.5](https://omnifaces.org/docs/vdldoc/2.5/) - [2.4](https://omnifaces.org/docs/vdldoc/2.4/) - [2.3](https://omnifaces.org/docs/vdldoc/2.3/) - [2.2](https://omnifaces.org/docs/vdldoc/2.2/) - [2.1](https://omnifaces.org/docs/vdldoc/2.1/) - [2.0](https://omnifaces.org/docs/vdldoc/2.0/) 
   - [1.14](https://omnifaces.org/docs/vdldoc/1.14/) - [1.13](https://omnifaces.org/docs/vdldoc/1.13/) - [1.12](https://omnifaces.org/docs/vdldoc/1.12/) - [1.11](https://omnifaces.org/docs/vdldoc/1.11/) - [1.10](https://omnifaces.org/docs/vdldoc/1.10/)
   - [1.8](https://omnifaces.org/docs/vdldoc/1.8/) - [1.7](https://omnifaces.org/docs/vdldoc/1.7/) - [1.6](https://omnifaces.org/docs/vdldoc/1.6/) - [1.5](https://omnifaces.org/docs/vdldoc/1.5/) - [1.4](https://omnifaces.org/docs/vdldoc/1.4/) - [1.3](https://omnifaces.org/docs/vdldoc/1.3/) - [1.2](https://omnifaces.org/docs/vdldoc/1.2/) - [1.1](https://omnifaces.org/docs/vdldoc/1.1/) - [1.0](https://omnifaces.org/docs/vdldoc/1.0/)
 * [OmniFaces wiki pages](https://github.com/omnifaces/omnifaces/wiki)
   * [Compatibility Matrix](https://github.com/omnifaces/omnifaces/wiki/Compatibility-Matrix)
   * [Known Issues (general)](https://github.com/omnifaces/omnifaces/wiki/Known-Issues-(general))
   * [Known Issues (CDI)](https://github.com/omnifaces/omnifaces/wiki/Known-Issues-(CDI))
   * [Combine hardcoded PrimeFaces resources using CombinedResourceHandler](https://github.com/omnifaces/omnifaces/wiki/Combine-hardcoded-PrimeFaces-resources-using-CombinedResourceHandler)


## Books

### The Definitive Guide to Jakarta Faces in Jakarta EE 10

[![The Definitive Guide to Jakarta Faces in Jakarta EE 10](https://i.imgur.com/z2b7eWj.jpg)](https://amazon.com/dp/1484273095)

[The Definitive Guide to Jakarta Faces in Jakarta EE 10](https://amazon.com/dp/1484273095) is since March 16, 2022 available at Amazon.com. This book is authored by the creators of OmniFaces, Bauke Scholtz and Arjan Tijms. This book is definitely a must read for anyone working with Jakarta Faces or interested in Jakarta Faces. It uncovers the best practices and hidden gems of Jakarta Faces.

### The Definitive Guide to JSF in Java EE 8

[![The Definitive Guide to JSF in Java EE 8](https://i.imgur.com/Xv9EVv4m.jpg)](https://amazon.com/dp/1484233867)

[The Definitive Guide to JSF in Java EE 8](https://amazon.com/dp/1484233867) is since July 11, 2018 available at Amazon.com. This book is authored by the creators of OmniFaces, Bauke Scholtz and Arjan Tijms. This book is definitely a must read for anyone working with JSF or interested in JSF. It uncovers the best practices and hidden gems of JSF. The source code of the book's examples can be found at [GitHub](https://github.com/omnifaces/definitive-guide-to-jsf-in-javaee8).

### Pro CDI 2 in Java EE 8

[![Pro CDI 2 in Java EE 8](https://i.imgur.com/prQvurz.png)](https://amazon.com/dp/1484243625)

[Pro CDI 2 in Java EE 8](https://amazon.com/dp/1484243625) is available on Amazon.com since September 7, 2019. This book too is authored by members of the OmniFaces team, Jan Beernink and Arjan Tijms. It covers the history of CDI in great depth, and discusses core concepts, in addition to explaning many practical cases. CDI is the ultimate companion to JSF and therefor this book is a must-read for any JSF developer. The source code of the book's examples can be found at [GitHub](https://github.com/omnifaces/https://github.com/omnifaces/pro-cdi-2-in-java-ee-8).


### Mastering OmniFaces

[![Mastering OmniFaces](https://i.imgur.com/VmYCHdLm.jpg)](https://www.amazon.com/dp/1908689293)

[Mastering OmniFaces](https://www.amazon.com/dp/1908689293) is since October 5, 2015 available at Amazon.com. This book was created in cooperation with the creators of OmniFaces, Bauke Scholtz and Arjan Tijms. From the beginning on, they worked together with Anghel Leonard and Constantin Alin to get this book ready, and have reviewed it from top to bottom.

A little over 500 pages, this book goes into depth identifying general JSF problems and describing how OmniFaces has solved it, hereby uncovering several patterns and tricks. Basically, the working of every OmniFaces component, taghandler, converter, validator, and several handlers and listeners is break down in the book in a problem-to-solution approach. Reading this book is a true learning exercise as to exploiting JSF API, creating custom components, renderers, tagfiles and what not provided by JSF API in order to solve common problems.

A must read if you also like [Mastering JSF 2.2](https://www.amazon.com/dp/1782176462) from the same author!

### PrimeFaces & OmniFaces powers combined 

[![PrimeFaces & OmniFaces powers combined](https://i.imgur.com/D3iRI8qm.jpg)](https://leanpub.com/PrimeFaces-OmniFaces-Powers-Combined)

[PrimeFaces & OmniFaces powers combined](https://leanpub.com/PrimeFaces-OmniFaces-Powers-Combined) is an e-book of Anghel Leonard containing complete examples showing off situations when the PrimeFaces UIs take advantage of OmniFaces help.


## Support

If you have specific programming problems or questions related to the OmniFaces library, feel free to post a question on [Stack Overflow](https://stackoverflow.com) using at least the [`jsf`](https://stackoverflow.com/questions/tagged/jsf) and [`omnifaces`](https://stackoverflow.com/questions/tagged/omnifaces) tags.

If you have found bugs or have new ideas, feel free to open a [new issue](https://github.com/omnifaces/omnifaces/issues).

If you have general feedback that's not either a question, bug report or feature request, or if you have a review/rating, please feel free to leave it at [OpenHUB](https://www.openhub.net/p/omnifaces).


## OmniFaces in the worldwide news and literature

 * [Mojarra vs. OmniFaces @ViewScoped: @PreDestroy and garbage collection](https://stackoverflow.com/q/40569971/157882)
 * [Mocking JSF's FacesContext](https://blog.andresteingress.com/2017/09/24/mocking-the-facescontext.html)
 * [JAXenter - OmniFaces 2.6 will das JSF-Leben leichter machen](https://jaxenter.de/omnifaces-jsf-52496)
 * [Oracle - Java Magazine January/February 2016](http://www.javamagazine.mozaicreader.com/JanFeb2016#&pageSet=23&page=0)
 * [Oracle - Oracle Announces Winners of the 2015 Duke’s Choice Award](https://www.oracle.com/corporate/pressrelease/dukes-award-102815.html)
 * [Oracle - Duke’s Choice Awards 2015](https://community.oracle.com/docs/DOC-949972)
 * [YouTube - Programação Web com Java - 177: Introdução ao OmniFaces](https://www.youtube.com/watch?v=xojCLTjN9n4) - [193: SelectItemsConverter](https://www.youtube.com/watch?v=_sNP0RyPMtg) - [197: ResetInputAjaxActionListener](https://www.youtube.com/watch?v=bkbhxR76PTM) (Portuguese)
 * [ZEEF - OmniFaces Utilities by Anghel Leonard](https://omnifaces-utilities.zeef.com/anghel.leonard)
 * [Beyond Java - OmniFaces CombinedResourceHandler Gives Your Application a Boost](https://www.beyondjava.net/blog/omnifaces-combinedresourcehandler-gives-your-application-a-boost/)
 * [JAXenter - JSF-Bibliothek OmniFaces 2.0 erschienen](https://jaxenter.de/news/jsf-bibliothek-omnifaces-2-0-177727) (German)
 * [OSChina - OmniFaces 2.0 发布，JSF2 工具库](https://www.oschina.net/news/57372/omnifaces-2-0-released) (Chinese)
 * [OmniFaces Fans - OmniFaces 2.0 is here!](http://omnifaces-fans.blogspot.nl/2014/11/omnifaces-20-is-here_88.html)
 * [Beyond Java - OmniFaces 2.0 released](https://www.beyondjava.net/blog/newsflash-omnifaces-2-0-released/)
 * [Thoughts on software development - Building dynamic responsive multi-level menus with plain HTML and OmniFaces](http://ovaraksin.blogspot.nl/2014/12/building-dynamic-responsive-multi-level.html)
 * [Java vs .NET SQLWorld presentation](https://slideshare.net/odashinsuke/java-36899088/9) (Japanese)
 * [Mastering JavaServer Faces 2.2 - a.o. Chapter 7](https://my.safaribooksonline.com/book/programming/java/9781782176466/7dot-jsf-and-ajax/ch07_html) 
 * [Bytes Lounge - How to cache component rendering in JSF example](https://byteslounge.com/tutorials/how-to-cache-component-rendering-in-jsf-example)
 * [Beyond Java - Why JSF 2.0 Hides Exceptions When Using AJAX (about FullAjaxExceptionHandlerFactory)](https://beyondjava.net/blog/jsf-2-0-hides-exceptions-ajax)
 * [Adictos al Trabajo - Omnifaces: una librería de utilidades para JSF2](https://www.adictosaltrabajo.com/2013/09/29/omnifaces-jsf2-utility-library/) (Spanish)
 * [JSFCentral - Arjan Tijms and Bauke Scholtz (BalusC) Talk about OmniFaces and Building zeef.com](http://content.jsfcentral.com/c/journal_articles/view_article_content?groupId=35702&articleId=91827&version=1.7)
 * [OIO - JSF Performance Tuning (with CombinedResourceHandler)](https://blog.oio.de/2013/05/06/jsf-performance-tuning/)
 * [Challenge Java EE - JSFでPDFファイルを開いたりダウンロードしたりしてみる (download PDF files in JSF)](https://kikutaro777.hatenablog.com/entry/2013/04/09/181002) (Japanese)
 * [OSChina - OmniFaces 1.4 发布，JSF2 工具库](https://oschina.net/news/38546/omnifaces-1-4) (Chinese)
 * [JAXenter - JSF-Bibliothek OmniFaces vereinfacht HTML Messages](https://jaxenter.de/news/JSF-Bibliothek-OmniFaces-vereinfacht-HTML-Messages) (German)
 * [JAXenter - Besser spät als nie: JSF-Bibliothek OmniFaces 1.4 mit überarbeiteten FacesViews](https://jaxenter.de/besser-spat-als-nie-jsf-bibliothek-omnifaces-1-4-mit-uberarbeiteten-facesviews-3594) (German)
 * [JAXenter - Nie wieder "View Expired": JSF-Bibliothek OmniFaces 1.3 erschienen](https://jaxenter.de/nie-wieder-quotview-expiredquot-jsf-bibliothek-omnifaces-1-3-erschienen-3942) (German)
 * [Entwicklertagebuch - OmniFaces - Das Schweizer Taschenmescher für JSF-Entwickler](http://entwicklertagebuch.com/blog/2012/10/omnifaces-das-schweizer-taschenmesser-fur-jsf-entwickler-2/) (German)
 * [Un Poco de Java - OmniFaces: librería de utilidad para JSF](https://unpocodejava.wordpress.com/2012/07/26/omnifaces-libreria-de-utilidad-para-jsf) (Spanish)
 * [InfoQ - OmniFaces: uma biblioteca de utilitários para JSF](https://www.infoq.com/br/news/2012/09/jsf-omnifaces) (the Brazilian-Portuguese translation of previous English article)
 * [InfoQ - OmniFaces: A Utility Library for Java Server Faces](https://www.infoq.com/news/2012/07/omnifaces-1)
