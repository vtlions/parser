package collections;

public class Maven {

	private String groupId;
	private String artifactId;
	private String version;
	private String project;
	private String modelVersion;
	private String name;

	public Maven() {

	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Maven [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + ", modelVersion="
				+ modelVersion + ", name=" + name + "]";
	}
	
	

}
