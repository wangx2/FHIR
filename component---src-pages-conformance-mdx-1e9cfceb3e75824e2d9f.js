(window.webpackJsonp=window.webpackJsonp||[]).push([[6],{380:function(e,t,a){"use strict";a.r(t),a.d(t,"_frontmatter",function(){return o}),a.d(t,"default",function(){return b});a(10),a(5),a(6),a(3),a(8),a(2),a(1);var n=a(104),r=a(389);function i(){return(i=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var a=arguments[t];for(var n in a)Object.prototype.hasOwnProperty.call(a,n)&&(e[n]=a[n])}return e}).apply(this,arguments)}var o={},c={_frontmatter:o},l=r.a;function b(e){var t=e.components,a=function(e,t){if(null==e)return{};var a,n,r={},i=Object.keys(e);for(n=0;n<i.length;n++)a=i[n],t.indexOf(a)>=0||(r[a]=e[a]);return r}(e,["components"]);return Object(n.b)(l,i({},c,a,{components:t,mdxType:"MDXLayout"}),Object(n.b)("h1",{id:"conformance-to-the-hl7-fhir-specification"},"Conformance to the HL7 FHIR Specification"),Object(n.b)("p",null,"The IBM Server for HL7 FHIR aims to be a conformant implementation of the HL7 FHIR specification, version 4.0.0 (R4). However, the FHIR specification is very broad and not all implementations are expected to implement every feature. We prioritize performance and configurability over spec coverage."),Object(n.b)("h2",{id:"capability-statement"},"Capability statement"),Object(n.b)("p",null,"The HL7 FHIR specification defines ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/http.html#capabilities"}),"an interaction")," for retrieving a machine-readable description of the server’s capabilities via the ",Object(n.b)("inlineCode",{parentName:"p"},"[base]/metadata")," endpoint. The IBM Server for HL7 FHIR implements this interaction and generates a ",Object(n.b)("inlineCode",{parentName:"p"},"CapabilityStatement")," resource based on the current server configuration. While the ",Object(n.b)("inlineCode",{parentName:"p"},"CapabilityStatement")," resource is ideal for certain uses, this markdown document provides a human-readable summary of important details, with a special focus on limitations of the current implementation and deviations from the specification."),Object(n.b)("h2",{id:"fhir-http-api"},"FHIR HTTP API"),Object(n.b)("p",null,"The HL7 FHIR specification is more than just a content standard. It defines an ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/http.html"}),"HTTP API")," for creating, reading, updating, deleting, and searching over FHIR resources. The IBM Server for HL7 FHIR implements the full API for every resource defined in the specification, with the following exceptions:"),Object(n.b)("ul",null,Object(n.b)("li",{parentName:"ul"},"history is only supported at the resource instance level (no resource type history and no whole-system history)"),Object(n.b)("li",{parentName:"ul"},"there are parts of the FHIR search specification which are not fully implemented as documented in the following section")),Object(n.b)("h2",{id:"search"},"Search"),Object(n.b)("p",null,"The IBM Server for HL7 FHIR supports search parameters of type ",Object(n.b)("inlineCode",{parentName:"p"},"Number"),", ",Object(n.b)("inlineCode",{parentName:"p"},"Date/DateTime"),", ",Object(n.b)("inlineCode",{parentName:"p"},"String"),", ",Object(n.b)("inlineCode",{parentName:"p"},"Token"),", ",Object(n.b)("inlineCode",{parentName:"p"},"Reference"),", ",Object(n.b)("inlineCode",{parentName:"p"},"Quantity"),", and ",Object(n.b)("inlineCode",{parentName:"p"},"URI"),"."),Object(n.b)("p",null,"Search parameters of type ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#composite"}),"Composite")," and ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#special"}),"Special")," are not currently supported."),Object(n.b)("p",null,"For all other types, the IBM Server for HL7 FHIR supports the parameters defined in the\nspecification and allows for the configuration of additional ones."),Object(n.b)("h3",{id:"search-parameters"},"Search parameters"),Object(n.b)("p",null,"Search parameters defined in the specification can be found by browsing the R4 FHIR specification by resource type. For example, to find the search parameters for a Patient resource, navigate to ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/patient.html"}),"https://www.hl7.org/fhir/R4/patient.html")," and scroll to the Search Parameters section near the end of the page."),Object(n.b)("p",null,"In addition, the following search parameters are supported on all resources:"),Object(n.b)("ul",null,Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_id")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_lastUpdated")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_profile")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_security")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_source")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_tag"))),Object(n.b)("p",null,"The ",Object(n.b)("inlineCode",{parentName:"p"},"_text"),", ",Object(n.b)("inlineCode",{parentName:"p"},"_content"),", ",Object(n.b)("inlineCode",{parentName:"p"},"_list"),", and ",Object(n.b)("inlineCode",{parentName:"p"},"_query")," parameters are not supported at this time."),Object(n.b)("p",null,"Finally, the specification defines a set of ",Object(n.b)("q",null,"Search result parameters")," for controlling the search behavior. The IBM Server for HL7 FHIR supports the following:"),Object(n.b)("ul",null,Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_sort")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_count")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_include")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_revinclude")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"_elements"))),Object(n.b)("p",null,"The ",Object(n.b)("inlineCode",{parentName:"p"},"_count")," parameter can be used to return at most 1000 records. If the client specifies a ",Object(n.b)("inlineCode",{parentName:"p"},"_count")," of over 1000, the page size is capped at 1000. If the client specifies a ",Object(n.b)("inlineCode",{parentName:"p"},"_count")," of 1000 or less, the server honors the client request."),Object(n.b)("p",null,"The ",Object(n.b)("inlineCode",{parentName:"p"},"_summary"),", ",Object(n.b)("inlineCode",{parentName:"p"},"_total"),", ",Object(n.b)("inlineCode",{parentName:"p"},"_contained"),", and ",Object(n.b)("inlineCode",{parentName:"p"},"_containedType")," parameters are not supported at this time."),Object(n.b)("h3",{id:"custom-search-parameters"},"Custom search parameters"),Object(n.b)("p",null,"Custom search parameters are search parameters that are not defined in the FHIR R4 specification, but are configured for search on the IBM Server for HL7 FHIR. You can configure custom parameters for either extension elements or for elements that are defined in the specification but without a corresponding search parameter."),Object(n.b)("p",null,"For information on how to specify custom search parameters, see ",Object(n.b)("a",i({parentName:"p"},{href:"FHIRServerUserGuide.md#35-search-parameters"}),"Section 3.5 Search parameters")," of the FHIR Server User Guide."),Object(n.b)("h3",{id:"search-modifiers"},"Search modifiers"),Object(n.b)("p",null,"FHIR search modifiers are described at ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#modifiers"}),"https://www.hl7.org/fhir/R4/search.html#modifiers")," and vary by search parameter type. The IBM Server for HL7 FHIR implements a subset of the spec-defined search modifiers that is defined in the following table:"),Object(n.b)("table",null,Object(n.b)("thead",{parentName:"table"},Object(n.b)("tr",{parentName:"thead"},Object(n.b)("th",i({parentName:"tr"},{align:null}),"FHIR Search Parameter Type"),Object(n.b)("th",i({parentName:"tr"},{align:null}),"Supported Modifiers"),Object(n.b)("th",i({parentName:"tr"},{align:null}),"“Default” search behavior when no Modifier is present"))),Object(n.b)("tbody",{parentName:"table"},Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"String"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":exact"),",",Object(n.b)("inlineCode",{parentName:"td"},":contains"),",",Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Performs a “starts with” search that is case-insensitive and accent-insensitive")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"Reference"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":[type]"),",",Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Performs an exact match search")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"URI"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":below"),",",Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Performs a “starts with” search")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"Token"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":below"),",",Object(n.b)("inlineCode",{parentName:"td"},":not"),",",Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Performs an exact match search")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"Number"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Honors prefix if present, otherwise performs an exact match search")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"Date"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Honors prefix if present, otherwise performs an exact match search")),Object(n.b)("tr",{parentName:"tbody"},Object(n.b)("td",i({parentName:"tr"},{align:null}),"Quantity"),Object(n.b)("td",i({parentName:"tr"},{align:null}),Object(n.b)("inlineCode",{parentName:"td"},":missing")),Object(n.b)("td",i({parentName:"tr"},{align:null}),"Honors prefix if present, otherwise performs an exact match search")))),Object(n.b)("p",null,"Note that the default IBM Server for HL7 FHIR behavior for URI search parameters differs from the behavior defined at ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#uri"}),"https://www.hl7.org/fhir/R4/search.html#uri"),"."),Object(n.b)("p",null,"At present, modifiers cannot be used with chained parameters. For example, a search with query string like ",Object(n.b)("inlineCode",{parentName:"p"},"subject:Basic.date:missing")," will result in an ",Object(n.b)("inlineCode",{parentName:"p"},"OperationOutcome")," explaining that the search parameter could not be processed."),Object(n.b)("p",null,"The ",Object(n.b)("inlineCode",{parentName:"p"},":text")," modifier is not supported in this version of the FHIR server and use of this modifier will results in an HTTP 400 error with an ",Object(n.b)("inlineCode",{parentName:"p"},"OperationOutcome")," that describes the failure."),Object(n.b)("p",null,"Due to performance implications, the ",Object(n.b)("inlineCode",{parentName:"p"},":exact")," modifier should be used for String searches where possible."),Object(n.b)("h3",{id:"search-prefixes"},"Search prefixes"),Object(n.b)("p",null,"FHIR search prefixes are described at ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#prefix"}),"https://www.hl7.org/fhir/R4/search.html#prefix"),"."),Object(n.b)("p",null,"As defined in the specification, the following prefixes are supported for Number, Date, and Quantity search parameters:"),Object(n.b)("ul",null,Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"eq")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"ne")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"gt")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"lt")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"gt")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"le")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"sa")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"eb")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"ap"))),Object(n.b)("p",null,"For explicit range targets (parameter values extracted from Period and Range elements), the prefixes are interpreted as according to ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#prefix"}),"https://www.hl7.org/fhir/R4/search.html#prefix"),"."),Object(n.b)("p",null,"For example, a search like ",Object(n.b)("inlineCode",{parentName:"p"},"Observation?date=2018-10-29T12:00:00Z")," would ",Object(n.b)("em",{parentName:"p"},"not")," match an Observation with an effectivePeriod of ",Object(n.b)("inlineCode",{parentName:"p"},"start=2018-10-29")," and ",Object(n.b)("inlineCode",{parentName:"p"},"end=2018-10-30")," because “the search range does not fully contain the range of the target value.” Similarly, a search like ",Object(n.b)("inlineCode",{parentName:"p"},"range=5||mg")," would not match a range value with ",Object(n.b)("inlineCode",{parentName:"p"},"low = 1 mg")," and ",Object(n.b)("inlineCode",{parentName:"p"},"high = 10 mg"),". To obtain all range values (Period or Range) which contain a specific value, please use the ",Object(n.b)("inlineCode",{parentName:"p"},"ap")," prefix which is defined to match when “the range of the search value overlaps with the range of the target value.”"),Object(n.b)("p",null,"For other target values (parameter values extracted from elements that are not a Period or Range), ",Object(n.b)("inlineCode",{parentName:"p"},"ap")," is treated like ",Object(n.b)("inlineCode",{parentName:"p"},"eq"),", ",Object(n.b)("inlineCode",{parentName:"p"},"eb")," is treated like ",Object(n.b)("inlineCode",{parentName:"p"},"lt"),", and ",Object(n.b)("inlineCode",{parentName:"p"},"sa")," is treated like ",Object(n.b)("inlineCode",{parentName:"p"},"gt"),". Please note that this ",Object(n.b)("inlineCode",{parentName:"p"},"ap")," behavior differs from the behavior recommended in the specification."),Object(n.b)("p",null,"In the absence of a prefix, the default behavior for number, date, and quantity searches is an exact match search."),Object(n.b)("p",null,"The ",Object(n.b)("inlineCode",{parentName:"p"},"eb")," and ",Object(n.b)("inlineCode",{parentName:"p"},"ap")," prefixes are not supported for searches which target values of type integer (or derived types)."),Object(n.b)("p",null,"If not specified on a query string, the default prefix is ",Object(n.b)("inlineCode",{parentName:"p"},"eq"),"."),Object(n.b)("h3",{id:"searching-on-date"},"Searching on Date"),Object(n.b)("p",null,"The FHIR server adheres to the specification except in cases where a time is included in the search query value. When a time is specified, the implementation requires an hour, minute, second, and timezone value. Including these values is consistent with the way in which ",Object(n.b)("inlineCode",{parentName:"p"},"instant")," and ",Object(n.b)("inlineCode",{parentName:"p"},"dateTime")," data types are defined at ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/datatypes.html#primitive"}),"https://www.hl7.org/fhir/R4/datatypes.html#primitive"),". However, the implementation differs from the description at ",Object(n.b)("a",i({parentName:"p"},{href:"https://www.hl7.org/fhir/R4/search.html#date"}),"https://www.hl7.org/fhir/R4/search.html#date"),", which allows clients to include hours and minutes, but to omit values for seconds and time zone."),Object(n.b)("p",null,"Indexing fields of type ",Object(n.b)("inlineCode",{parentName:"p"},"Timing")," is not well-defined in the specification and is not supported in this version of the IBM Server for HL7 FHIR."),Object(n.b)("h3",{id:"searching-on-token"},"Searching on Token"),Object(n.b)("p",null,"For search parameters of type token, resource values are not indexed unless the resource instance contains both a ",Object(n.b)("inlineCode",{parentName:"p"},"system")," ",Object(n.b)("strong",{parentName:"p"},"and")," ",Object(n.b)("inlineCode",{parentName:"p"},"code"),". The server implements the following variations of token search defined in the specification:"),Object(n.b)("ul",null,Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"[parameter]=[code]")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"[parameter]=[system]|[code]")),Object(n.b)("li",{parentName:"ul"},Object(n.b)("inlineCode",{parentName:"li"},"[parameter]=|[code]"))),Object(n.b)("p",null,"However, the ",Object(n.b)("inlineCode",{parentName:"p"},"|[code]")," variant currently behaves like the ",Object(n.b)("inlineCode",{parentName:"p"},"[code]")," option, matching code values irrespective of the system instead of matching only on elements with missing/null system values as defined in the spec."),Object(n.b)("p",null,"The IBM Server for HL7 FHIR does not yet support searching a token value by codesystem, irrespective of the value (",Object(n.b)("inlineCode",{parentName:"p"},"|[system]|"),")."),Object(n.b)("p",null,"For search parameters of type token that are defined on data fields of type ",Object(n.b)("inlineCode",{parentName:"p"},"ContactPoint"),", the FHIR server currently uses the ",Object(n.b)("inlineCode",{parentName:"p"},"ContactPoint.system")," and the ",Object(n.b)("inlineCode",{parentName:"p"},"ContactPoint.value")," instead of the ",Object(n.b)("inlineCode",{parentName:"p"},"ContactPoint.use")," field as described in the specification."),Object(n.b)("p",null,"Searching string values via a token search parameter is not currently supported."),Object(n.b)("h3",{id:"searching-on-number"},"Searching on Number"),Object(n.b)("p",null,"For fields of type ",Object(n.b)("inlineCode",{parentName:"p"},"decimal"),", the IBM Server for HL7 FHIR does not compute an implicit range for search. Search query values must match to the same precision, or greater precision, as the value in the resource."),Object(n.b)("h3",{id:"searching-on-quantity"},"Searching on Quantity"),Object(n.b)("p",null,"Quantity elements are not indexed unless they include either a valid ",Object(n.b)("inlineCode",{parentName:"p"},"system")," ",Object(n.b)("strong",{parentName:"p"},"and")," ",Object(n.b)("inlineCode",{parentName:"p"},"code")," for their unit ",Object(n.b)("strong",{parentName:"p"},"or")," a human-readable ",Object(n.b)("inlineCode",{parentName:"p"},"unit")," field. Quantities that don’t include a ",Object(n.b)("inlineCode",{parentName:"p"},"value")," element are also skipped."),Object(n.b)("p",null,"The FHIR server does not perform any unit conversion or unit manipulation at this time. Quantity values ",Object(n.b)("strong",{parentName:"p"},"must")," be searched using the same unit ",Object(n.b)("inlineCode",{parentName:"p"},"code")," that is included in the original resource. If, and only if, a coded unit is not present on a resource, then the FHIR server indexes the human-readable ",Object(n.b)("inlineCode",{parentName:"p"},"unit")," field, which can then be searched by omitting the ",Object(n.b)("inlineCode",{parentName:"p"},"system")," in the search query."),Object(n.b)("p",null,"The IBM Server for HL7 FHIR does not consider the ",Object(n.b)("inlineCode",{parentName:"p"},"Quantity.comparator")," field as part of search processing at this time.\nSimilar to Numeric searches, the FHIR Server does not compute an implicit range for quantity values…the precise number given in the resource is required for retrieval via standard search (i.e. searches with either no prefix or the ",Object(n.b)("inlineCode",{parentName:"p"},"eq")," prefix)."),Object(n.b)("h3",{id:"searching-on-uri"},"Searching on URI"),Object(n.b)("p",null,"URI searches on the IBM Server for HL7 FHIR are case-insensitive, similar to the default behavior of searching on string values."),Object(n.b)("h2",{id:"hl7-fhir-r4-v400-errata"},"HL7 FHIR R4 (v4.0.0) errata"),Object(n.b)("p",null,"We will add information here as we find issues with the artifacts provided with this version of the specification."))}b.isMDXComponent=!0},387:function(e){e.exports={data:{site:{pathPrefix:"/FHIR"}}}},388:function(e){e.exports={data:{site:{siteMetadata:{repository:{baseUrl:"https://github.com/IBM/FHIR",subDirectory:"/docs"}}}}}},389:function(e,t,a){"use strict";a(34),a(23);var n=a(2),r=a(387),i=a(1),o=a.n(i),c=a(193),l=a(90),b=a.n(l),s=a(71),p=a(122),h=a(4),d=a.n(h),m=a(368),u=function(e){var t,a=e.children,r=e.title,i=e.tabs,o=void 0===i?[]:i,c=e.shouldHideHeader;return Object(n.b)("div",{className:d()((t={},t[m.pageHeader]=m.pageHeader,t[m.pageHeaderSticky]=o.length,t[m.pageHeaderShifted]=c,t))},Object(n.b)("div",{className:"bx--grid"},Object(n.b)("div",{className:"bx--row"},Object(n.b)("div",{className:"bx--col-lg-12"},Object(n.b)("h1",{id:"page-title",className:m.text},r)))),a)},f=a(388),O=a(369),j=function(e){var t=e.relativePagePath,a=e.repository,r=f.data.site.siteMetadata.repository,i=a||r,o=i.baseUrl,c=o+"/tree/master"+i.subDirectory+"/src/pages"+t;return o?Object(n.b)("div",{className:"bx--row "+O.row},Object(n.b)("div",{className:"bx--col"},Object(n.b)("a",{className:O.link,href:c},"Edit this page on GitHub"))):null},N=a(194),g=a(29),v=a(370);var w=function(e){var t,a;function r(){return e.apply(this,arguments)||this}return a=e,(t=r).prototype=Object.create(a.prototype),t.prototype.constructor=t,t.__proto__=a,r.prototype.render=function(){var e=this.props,t=e.tabs,a=e.slug,r=a.split("/").filter(Boolean).slice(-1)[0],i=t.map(function(e){var t,i=b()(e,{lower:!0}),o=i===r,c=a.replace(r,i);return Object(n.b)("li",{key:e,className:d()((t={},t[v.selectedItem]=o,t),v.listItem)},Object(n.b)(g.Link,{className:v.link,to:""+c},e))});return Object(n.b)("div",{className:v.tabsContainer},Object(n.b)("div",{className:"bx--grid"},Object(n.b)("div",{className:"bx--row"},Object(n.b)("div",{className:"bx--col-lg-12 bx--col-no-gutter"},Object(n.b)("nav",null,Object(n.b)("ul",{className:v.list},i))))))},r}(o.a.Component),C=a(195);t.a=function(e){var t=e.pageContext,a=e.children,i=e.location,o=t.frontmatter,l=void 0===o?{}:o,h=t.relativePagePath,d=l.tabs,m=l.title,f=Object(s.c)(),O=!!d&&"down"===f,g=r.data.site.pathPrefix,v=g?i.pathname.replace(g,""):i.pathname,y=d?v.split("/").slice(-1)[0]||b()(d[0],{lower:!0}):"";return Object(n.b)(p.a,{shouldHideHeader:O,homepage:!1},Object(n.b)(u,{shouldHideHeader:O,title:m,label:"label",tabs:d},d&&Object(n.b)(w,{slug:v,tabs:d,currentTab:y})),Object(n.b)(C.a,{padded:!0},a,Object(n.b)(j,{relativePagePath:h})),Object(n.b)(N.a,{pageContext:t,location:i,slug:v,tabs:d,currentTab:y}),Object(n.b)(c.a,null))}}}]);
//# sourceMappingURL=component---src-pages-conformance-mdx-1e9cfceb3e75824e2d9f.js.map