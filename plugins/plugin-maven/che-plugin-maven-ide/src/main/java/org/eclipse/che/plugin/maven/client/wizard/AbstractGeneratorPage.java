/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.maven.client.wizard;

import static org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar.WIZARD_MODE_KEY;

import java.util.Map;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardMode;
import org.eclipse.che.ide.api.wizard.AbstractWizardPage;
import org.eclipse.che.plugin.maven.shared.MavenAttributes;

/**
 * Abstract implementation of {@link MavenGeneratorPage}.
 *
 * @see MavenGeneratorPage
 */
public abstract class AbstractGeneratorPage extends AbstractWizardPage<MutableProjectConfig>
    implements MavenGeneratorPage {

  @Override
  public boolean canSkip() {
    Map<String, String> options = dataObject.getOptions();
    String generator = options.get(MavenAttributes.GENERATOR_OPTION);

    ProjectWizardMode wizardMode = ProjectWizardMode.parse(context.get(WIZARD_MODE_KEY));

    return generator == null
        || !getGeneratorId().equals(generator)
        || wizardMode != ProjectWizardMode.CREATE;
  }
}