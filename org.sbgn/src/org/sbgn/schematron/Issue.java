package org.sbgn.schematron;

/**
 * Describes one issue found during schematron validation.
 * One validation run may produce multiple issues.
 */
public class Issue
{
	
	/**
	 * The Enum Severity.
	 */
	public enum Severity {
		/** Severity::warning. */
		WARNING,
		/** Severity::error. */
		ERROR
	};
	
	/** The severity. */
	private final Severity severity;
	
	/** The message. */
	private final String message;
	
	/** The diagnostic id. */
	private final String diagnosticId;
	
	/** The rule id. */
	private final String ruleId;
	
	/**
	 * The Constructor.
	 *
	 * @param role the role - either error or warning
	 * @param ruleId the rule id
	 * @param diagnosticId the diagnostic id
	 * @param message the message
	 */
	Issue (String role, String ruleId, String diagnosticId, String message)
	{
		this.message = message.trim();
		this.diagnosticId = diagnosticId;
		this.ruleId = ruleId;
		severity = (role.equalsIgnoreCase("error") ? Severity.ERROR : Severity.WARNING); 
	}
	
	/** Severity of the issue, i.e.: is it an error, or a warning?
	 *  
	 * @return the severity of the issue
	 */
	public Severity getSeverity() { return severity; }
	
	/**
	 * Human readable description of the issue.
	 *
	 * @return the rule description
	 */
	public String getRuleDescription() { return message; }

	/**
	 * identifier of the element that this issue is about.
	 *
	 * @return the about id
	 */
	public String getAboutId() { return diagnosticId; }
	
	/**
	 * identifier of the issue.
	 *
	 * @return the rule id
	 */
	public String getRuleId() { return ruleId; }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() { return severity + " at diagnosticId=" + diagnosticId + "; ruleId=" + ruleId + " Message: " + message; }
}
